#!/usr/bin/env python3
"""Enforce the modelling invariants `openapi.yaml` claims to follow.

`redocly lint` proves the document is valid OpenAPI 3.1. It does not prove the things this
contract actually depends on — that a strict, statically typed decoder can consume every response,
that no decimal ever became a JSON number, that every union is decidable from its tag alone. This
script checks exactly those, plus a set of hand-written payloads that must be accepted and a set
that must be rejected.

    python3 examples/lint_contract.py        # requires pyyaml; jsonschema for the payload checks

Exit status is non-zero on any error, so it can gate a change to the contract.
"""

from __future__ import annotations

import sys
from pathlib import Path

try:
    import yaml
except ImportError:  # pragma: no cover
    sys.exit('pyyaml is required: pip install pyyaml')

SPEC = Path(__file__).with_name('openapi.yaml')

# Request bodies are exempt from the "every property is required" rule on purpose: in a request,
# an absent key, an explicit null and an absent body all mean "use the default".
REQUEST_SCHEMAS = {
    'CreateSessionRequest',
    'CreateCheckoutRequest',
    'CreatePortalSessionRequest',
    'CreateTranscriptionRequest',
    'MeteroidWebhookEvent',
}

doc = yaml.safe_load(SPEC.read_text())
schemas = doc['components']['schemas']
errors: list[str] = []
warnings: list[str] = []


def walk(node, path=''):
    if isinstance(node, dict):
        yield path, node
        for key, value in node.items():
            yield from walk(value, f'{path}/{key}')
    elif isinstance(node, list):
        for i, value in enumerate(node):
            yield from walk(value, f'{path}/{i}')


def resolve(ref: str):
    node = doc
    for part in ref.removeprefix('#/').split('/'):
        if not isinstance(node, dict) or part not in node:
            return None
        node = node[part]
    return node


# --- every $ref points at something ------------------------------------------------------------
for path, node in walk(doc):
    ref = node.get('$ref')
    if isinstance(ref, str) and resolve(ref) is None:
        errors.append(f'dangling $ref {ref} at {path}')

# --- every union is decidable from an explicit tag ----------------------------------------------
for name, schema in schemas.items():
    disc = schema.get('discriminator')
    if not disc:
        if 'oneOf' in schema and any('$ref' in b and b['$ref'].startswith('#/components/schemas/')
                                     and resolve(b['$ref']).get('type') == 'object'
                                     for b in schema['oneOf']):
            errors.append(f'{name}: oneOf over objects without a discriminator')
        continue
    prop = disc['propertyName']
    branches = {b['$ref'] for b in schema.get('oneOf', []) if '$ref' in b}
    mapping = disc.get('mapping', {})
    if branches != set(mapping.values()):
        errors.append(f'{name}: discriminator mapping does not cover exactly the oneOf branches')
    for tag, ref in mapping.items():
        variant = resolve(ref)
        if variant is None:
            errors.append(f'{name}: mapping {tag} -> missing {ref}')
            continue
        tag_schema = variant.get('properties', {}).get(prop)
        if tag_schema is None:
            errors.append(f'{name}: variant {ref} does not declare `{prop}`')
        elif tag_schema.get('const') != tag:
            errors.append(f'{name}: variant {ref} const {tag_schema.get("const")!r} != tag {tag!r}')
        elif tag_schema.get('type') != 'string':
            errors.append(f'{name}: variant {ref} tag lacks `type: string`')
        if prop not in variant.get('required', []):
            errors.append(f'{name}: variant {ref} does not require `{prop}`')
        if variant.get('additionalProperties') is not False:
            errors.append(f'{name}: variant {ref} is not closed')

# --- strict objects, total `required` on responses ----------------------------------------------
# `MeteroidWebhookEvent` is the one deliberately open schema: Meteroid publishes no schema for
# webhook payloads, so the receiver must accept whatever arrives.
OPEN_SCHEMAS = {'MeteroidWebhookEvent'}

for name, schema in schemas.items():
    if schema.get('type') != 'object':
        continue
    extra = schema.get('additionalProperties', '<absent>')
    if name in OPEN_SCHEMAS:
        if extra is not True:
            errors.append(f'{name}: documented as an open schema but is not open')
    elif isinstance(extra, dict):
        pass  # a typed map, e.g. {"type": "string"} — closed in the way that matters
    elif extra is not False:
        errors.append(f'{name}: must set `additionalProperties: false` (found {extra!r})')
    if name in REQUEST_SCHEMAS:
        continue
    props, required = set(schema.get('properties', {})), set(schema.get('required', []))
    if props - required:
        errors.append(
            f'{name}: response property may be absent, use type [T, "null"] and require it: '
            f'{sorted(props - required)}')
    if required - props:
        errors.append(f'{name}: required names an undefined property: {sorted(required - props)}')

# --- decimals are strings, dates are strings ----------------------------------------------------
for path, node in walk(doc):
    if node.get('type') == 'number':
        errors.append(f'bare `number` at {path}: decimals must be strings')
    if node.get('format') in ('date', 'date-time'):
        t = node.get('type')
        if not (t == 'string' or (isinstance(t, list) and set(t) <= {'string', 'null'})):
            errors.append(f'{node["format"]} on non-string type {t} at {path}')

# --- every operation is fully described ---------------------------------------------------------
operation_ids: list[str] = []
for route, item in doc['paths'].items():
    for method, op in item.items():
        if method not in ('get', 'post', 'put', 'patch', 'delete'):
            continue
        operation_ids.append(op['operationId'])
        codes = set(op['responses'])
        if not any(c.startswith('2') for c in codes):
            errors.append(f'{op["operationId"]}: no 2xx response')
        if '500' not in codes:
            errors.append(f'{op["operationId"]}: no 500 response')
        if not any(c.startswith('4') for c in codes):
            warnings.append(f'{op["operationId"]}: no 4xx response')
        for code, resp in op['responses'].items():
            if code.startswith('2') or '$ref' in resp:
                continue
            schema = resp.get('content', {}).get('application/json', {}).get('schema', {})
            if schema.get('$ref') != '#/components/schemas/Error':
                errors.append(f'{op["operationId"]} {code}: not the shared Error envelope')
if len(set(operation_ids)) != len(operation_ids):
    errors.append(f'duplicate operationIds: {operation_ids}')

# --- documented error examples really satisfy the envelope ---------------------------------------
error_required = set(schemas['Error']['required'])
error_codes = set(schemas['ErrorCode']['enum'])


def check_examples(label, container):
    for ex_name, ex in container.items():
        value = ex.get('value', {})
        if missing := error_required - set(value):
            errors.append(f'example {label}.{ex_name} omits {sorted(missing)}')
        if value.get('code') not in error_codes:
            errors.append(f'example {label}.{ex_name} has unknown code {value.get("code")!r}')


for name, resp in doc['components']['responses'].items():
    check_examples(name, resp['content']['application/json'].get('examples', {}))
for route, item in doc['paths'].items():
    for method, op in item.items():
        if method not in ('get', 'post', 'put', 'patch', 'delete'):
            continue
        for code, resp in op['responses'].items():
            content = resp.get('content', {}).get('application/json', {})
            check_examples(f'{route} {code}', content.get('examples', {}))

# --- payloads that must be accepted, and payloads that must not ----------------------------------
try:
    from jsonschema import Draft202012Validator
except ImportError:
    warnings.append('jsonschema not installed; skipped the payload checks')
    Draft202012Validator = None

if Draft202012Validator is not None:
    for name, schema in schemas.items():
        try:
            Draft202012Validator.check_schema(schema)
        except Exception as exc:  # noqa: BLE001
            errors.append(f'{name}: not a valid JSON Schema: {exc}')

    entitlements = Draft202012Validator(
        {**doc, '$ref': '#/components/schemas/EntitlementListResponse'})

    def entitlement(value):
        return {'entitlements': [{'feature_code': 'f', 'feature_name': 'F', 'value': value}]}

    metered = {
        'type': 'METERED', 'enabled': True, 'limit': '600', 'consumed': '12.5',
        'remaining': '587.5', 'unlimited': False, 'reset_at': '2026-10-01T00:00:00Z',
        'reset_period': {'type': 'BILLING_CYCLE', 'interval': None, 'unit': None},
        'metric_code': 'transcription_minutes',
    }
    unlimited = {**metered, 'limit': None, 'consumed': None, 'remaining': None, 'unlimited': True,
                 'reset_at': None, 'metric_code': None,
                 'reset_period': {'type': 'CALENDAR', 'interval': 1, 'unit': 'MONTH'}}

    must_accept = {
        'metered': metered,
        'unlimited metered': unlimited,
        'boolean': {'type': 'BOOLEAN', 'enabled': False},
        'config number': {'type': 'CONFIG', 'value': {'kind': 'NUMBER', 'value': '90'}},
        'config text': {'type': 'CONFIG', 'value': {'kind': 'TEXT', 'value': 'gold'}},
        'config boolean': {'type': 'CONFIG', 'value': {'kind': 'BOOLEAN', 'value': True}},
        'config json': {'type': 'CONFIG', 'value': {'kind': 'JSON', 'value': {'a': [1, 2]}}},
    }
    for label, value in must_accept.items():
        for err in entitlements.iter_errors(entitlement(value)):
            errors.append(f'valid payload rejected ({label}): {err.message}')

    must_reject = {
        'decimal as a JSON number': {**metered, 'limit': 600},
        'nullable key omitted': {k: v for k, v in metered.items() if k != 'consumed'},
        'unknown property': {**metered, 'surprise': 1},
        'untagged union member': {'enabled': True},
        'unknown tag': {**metered, 'type': 'METRED'},
        'unknown calendar unit': {**unlimited,
                                  'reset_period': {'type': 'CALENDAR', 'interval': 1,
                                                   'unit': 'FORTNIGHT'}},
        'config value without a kind': {'type': 'CONFIG', 'value': {'value': '90'}},
    }
    for label, value in must_reject.items():
        if entitlements.is_valid(entitlement(value)):
            errors.append(f'invalid payload accepted ({label})')

    # A tagged value must match exactly one branch of its union — otherwise it is ambiguous and a
    # decoder's choice of branch depends on declaration order.
    for union, samples in (('EntitlementValue', [metered, unlimited,
                                                 must_accept['boolean'],
                                                 must_accept['config json']]),
                           ('ConfigValue', [{'kind': 'NUMBER', 'value': '1'},
                                            {'kind': 'BOOLEAN', 'value': True},
                                            {'kind': 'TEXT', 'value': 'x'},
                                            {'kind': 'JSON', 'value': None}])):
        branches = [b['$ref'] for b in schemas[union]['oneOf']]
        for sample in samples:
            matched = [b for b in branches
                       if Draft202012Validator({**doc, '$ref': b}).is_valid(sample)]
            if len(matched) != 1:
                errors.append(
                    f'{union}: a {sample.get("type") or sample.get("kind")} value matches '
                    f'{len(matched)} branches ({matched}); the union is ambiguous')

print(f'{SPEC.name}: {len(doc["paths"])} paths, '
      f'{sum(1 for _, i in doc["paths"].items() for m in i if m in ("get", "post"))} operations, '
      f'{len(schemas)} schemas')
for warning in warnings:
    print('warn ', warning)
for error in errors:
    print('ERROR', error)
print('FAIL' if errors else 'OK')
sys.exit(1 if errors else 0)
