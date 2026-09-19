/**
 * The contract, loaded once and turned into validators.
 *
 * Everything this suite asserts about response *shape* comes from
 * `examples/openapi.yaml` — nothing is hand-copied into a test. That is the whole
 * point: a schema that is transcribed into an assertion drifts from the contract the
 * moment somebody edits the YAML, and then the suite is quietly checking history.
 *
 * The document is handed to Ajv whole and compiled by JSON Pointer, so a validator is
 * always *the* schema the contract declares for that operation and status, dereferenced
 * the same way a code generator would dereference it.
 */

import { readFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

import _Ajv2020 from 'ajv/dist/2020.js';
import _addFormats from 'ajv-formats';
import type { ErrorObject, ValidateFunction } from 'ajv';
import { parse as parseYaml } from 'yaml';

// Ajv and ajv-formats are CommonJS. Depending on the loader, the default import is
// either the class itself or a namespace holding it — take whichever showed up.
/* eslint-disable @typescript-eslint/no-explicit-any */
const Ajv2020 = ((_Ajv2020 as any).default ?? _Ajv2020) as typeof _Ajv2020;
const addFormats = ((_addFormats as any).default ?? _addFormats) as typeof _addFormats;
/* eslint-enable @typescript-eslint/no-explicit-any */

const HERE = dirname(fileURLToPath(import.meta.url));

/** `examples/openapi.yaml`, relative to `examples/tests/contract/src/`. */
export const SPEC_PATH = resolve(HERE, '../../../openapi.yaml');

/** Base URI the document is registered under inside Ajv. */
const SPEC_ID = 'https://meteroid.dev/scribe/openapi.yaml';

export type HttpMethod = 'get' | 'post' | 'put' | 'patch' | 'delete';
const METHODS: HttpMethod[] = ['get', 'post', 'put', 'patch', 'delete'];

// The document is consumed structurally, so it is typed loosely on purpose.
type Node = Record<string, any>; // eslint-disable-line @typescript-eslint/no-explicit-any

export const spec: Node = parseYaml(readFileSync(SPEC_PATH, 'utf8')) as Node;

const ajv = new Ajv2020({
  // OpenAPI documents carry keywords JSON Schema does not know (`discriminator`,
  // `operationId`, …). Strict mode would reject them; we want them ignored, and the
  // unions still validate because every variant declares its tag as a `const`.
  strict: false,
  allErrors: true,
  allowUnionTypes: true,
  validateFormats: true,
  logger: false,
});
addFormats(ajv);
ajv.addSchema(spec, SPEC_ID);

// ---------------------------------------------------------------- JSON pointers

function escapeToken(token: string): string {
  return token.replace(/~/g, '~0').replace(/\//g, '~1');
}

function pointerTo(...tokens: (string | number)[]): string {
  return `#/${tokens.map((t) => escapeToken(String(t))).join('/')}`;
}

function readPointer(pointer: string): unknown {
  const tokens = pointer
    .replace(/^#\/?/, '')
    .split('/')
    .filter((t) => t.length > 0)
    .map((t) => t.replace(/~1/g, '/').replace(/~0/g, '~'));

  let node: unknown = spec;
  for (const token of tokens) {
    if (node === null || typeof node !== 'object') return undefined;
    node = (node as Node)[token];
  }
  return node;
}

/**
 * Follow a `$ref`-only node to the pointer it ultimately names.
 *
 * Used on *response* objects: `"400": { $ref: "#/components/responses/BadRequest" }`
 * has to be resolved before we can point at its schema, or we would end up validating
 * bodies against an OpenAPI Response Object (which, read as a schema, accepts anything).
 */
function derefPointer(pointer: string): string {
  let current = pointer;
  for (let hop = 0; hop < 8; hop += 1) {
    const node = readPointer(current);
    if (
      node !== null &&
      typeof node === 'object' &&
      typeof (node as Node).$ref === 'string' &&
      Object.keys(node as Node).length === 1
    ) {
      current = (node as Node).$ref as string;
      continue;
    }
    return current;
  }
  throw new Error(`$ref chain from ${pointer} is more than 8 hops deep.`);
}

// ---------------------------------------------------------------- operations

export interface OperationSpec {
  operationId: string;
  method: HttpMethod;
  /** Path template, e.g. `/api/transcriptions`. No operation takes a path parameter. */
  path: string;
  /** Declared status codes, ascending. */
  statuses: number[];
  /** status -> JSON pointer of the (dereferenced) Response Object. */
  responsePointers: Record<number, string>;
}

function collectOperations(): Record<string, OperationSpec> {
  const operations: Record<string, OperationSpec> = {};

  for (const [path, pathItem] of Object.entries(spec.paths as Node)) {
    for (const method of METHODS) {
      const operation = (pathItem as Node)[method] as Node | undefined;
      if (!operation) continue;

      const operationId = operation.operationId as string;
      if (!operationId) {
        throw new Error(`${method.toUpperCase()} ${path} has no operationId.`);
      }

      const responsePointers: Record<number, string> = {};
      for (const status of Object.keys(operation.responses as Node)) {
        responsePointers[Number(status)] = derefPointer(
          pointerTo('paths', path, method, 'responses', status),
        );
      }

      operations[operationId] = {
        operationId,
        method,
        path,
        statuses: Object.keys(responsePointers)
          .map(Number)
          .sort((a, b) => a - b),
        responsePointers,
      };
    }
  }

  return operations;
}

export const operations: Record<string, OperationSpec> = collectOperations();

export function operation(operationId: string): OperationSpec {
  const found = operations[operationId];
  if (!found) {
    throw new Error(
      `No operation "${operationId}" in ${SPEC_PATH}. Known: ${Object.keys(operations).join(', ')}.`,
    );
  }
  return found;
}

// ---------------------------------------------------------------- validators

const validatorCache = new Map<string, ValidateFunction>();

function compile(pointer: string): ValidateFunction {
  const cached = validatorCache.get(pointer);
  if (cached) return cached;

  const validate = ajv.getSchema(`${SPEC_ID}${pointer}`);
  if (!validate) {
    throw new Error(`The contract has no schema at ${pointer}.`);
  }
  validatorCache.set(pointer, validate);
  return validate;
}

/**
 * The validator for one operation's response body at one status.
 *
 * Throws when the contract does not declare that status at all — an undeclared status
 * is itself a conformance failure, and one the suite should report loudly rather than
 * skip past.
 */
export function responseValidator(operationId: string, status: number): ValidateFunction {
  const op = operation(operationId);
  const responsePointer = op.responsePointers[status];
  if (!responsePointer) {
    throw new Error(
      `${op.method.toUpperCase()} ${op.path} (${operationId}) responded ${status}, which the ` +
        `contract does not declare. Declared: ${op.statuses.join(', ')}.`,
    );
  }
  return compile(`${responsePointer}/content/application~1json/schema`);
}

/** The validator for a named schema under `components/schemas`. */
export function schemaValidator(name: string): ValidateFunction {
  return compile(pointerTo('components', 'schemas', name));
}

/** Every `components/schemas` name in the contract. */
export function schemaNames(): string[] {
  return Object.keys(spec.components.schemas as Node);
}

/**
 * The `examples:` the contract itself documents for an operation's status, as
 * `[name, value]` pairs. The harness self-test validates them against their own schema,
 * which is how we know the loader works before any backend is running.
 */
export function documentedExamples(operationId: string, status: number): [string, unknown][] {
  const op = operation(operationId);
  const pointer = op.responsePointers[status];
  if (!pointer) return [];
  const examples = readPointer(`${pointer}/content/application~1json/examples`);
  if (!examples || typeof examples !== 'object') return [];
  return Object.entries(examples as Node).map(([name, wrapper]) => [name, (wrapper as Node).value]);
}

// ---------------------------------------------------------------- reporting

export function formatValidationErrors(
  errors: ErrorObject[] | null | undefined,
  data: unknown,
): string {
  const lines = (errors ?? []).map((error) => {
    const where = error.instancePath === '' ? '(root)' : error.instancePath;
    const params = Object.entries(error.params ?? {})
      .filter(([key]) => key !== 'passingSchemas')
      .map(([key, value]) => `${key}=${JSON.stringify(value)}`)
      .join(' ');
    return `  ${where} ${error.message}${params ? ` [${params}]` : ''}`;
  });

  const body = JSON.stringify(data, null, 2);
  const truncated = body.length > 4000 ? `${body.slice(0, 4000)}\n… (truncated)` : body;
  return `${lines.join('\n')}\n\nbody:\n${truncated}`;
}
