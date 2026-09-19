/**
 * The suite testing itself. **Runs entirely offline** — no backend, no Meteroid.
 *
 * A conformance suite is only worth what its validator is worth. A schema loader that
 * silently resolves to `{}` accepts every response ever sent and reports a perfect score,
 * which is strictly worse than no suite at all. So before anything is asserted about a
 * backend, this file proves that:
 *
 *  * every schema the contract declares actually compiles;
 *  * the validators *reject* bodies that violate the contract's own rules (the negative
 *    controls below are the important half);
 *  * the examples the contract documents validate against the schemas it documents them
 *    for — i.e. the YAML is self-consistent;
 *  * the suite exercises every operation the contract declares;
 *  * the two pieces of arithmetic the suite does itself — exact decimals and Standard
 *    Webhooks signing — match the SDKs, checked against a published test vector.
 *
 * When the rest of the suite is red because nothing is listening on `BASE_URL`, this file
 * still passes. That is the signal that the failures are environmental, not code.
 */

import { readFileSync, readdirSync } from 'node:fs';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { addDecimal, billableMinutes, compareDecimal, secondsForMinutes, subtractDecimal } from '../src/decimal.js';
import { mintSessionToken } from '../src/session.js';
import {
  documentedExamples,
  operations,
  responseValidator,
  schemaNames,
  schemaValidator,
  SPEC_PATH,
} from '../src/spec.js';
import { signWebhook, signedWebhookRequest } from '../src/webhook.js';

const TESTS_DIR = dirname(fileURLToPath(import.meta.url));

describe('contract loads', () => {
  it('parses examples/openapi.yaml and finds its operations', () => {
    expect(SPEC_PATH.endsWith('examples/openapi.yaml')).toBe(true);
    expect(Object.keys(operations).length).toBeGreaterThan(0);
  });

  it('compiles a validator for every declared response of every operation', () => {
    for (const op of Object.values(operations)) {
      for (const status of op.statuses) {
        const validate = responseValidator(op.operationId, status);
        expect(
          typeof validate,
          `${op.operationId} ${status} did not compile to a validator`,
        ).toBe('function');
      }
    }
  });

  it('compiles every named schema in components/schemas', () => {
    for (const name of schemaNames()) {
      expect(typeof schemaValidator(name), `schema ${name} did not compile`).toBe('function');
    }
  });

  it('refuses to validate against a status the contract does not declare', () => {
    // 418 is declared nowhere. A backend that invents a status must fail the suite
    // rather than slip through unvalidated.
    expect(() => responseValidator('getHealth', 418)).toThrow(/does not declare/);
  });

  it('validates the examples the contract documents for its own error responses', () => {
    let checked = 0;
    for (const op of Object.values(operations)) {
      for (const status of op.statuses) {
        const validate = responseValidator(op.operationId, status);
        for (const [name, value] of documentedExamples(op.operationId, status)) {
          const valid = validate(value);
          expect(
            valid,
            `${op.operationId} ${status} example "${name}" does not match its own schema: ` +
              JSON.stringify(validate.errors),
          ).toBe(true);
          checked += 1;
        }
      }
    }
    expect(checked, 'the contract documents no response examples at all').toBeGreaterThan(0);
  });
});

describe('validators are actually strict (negative controls)', () => {
  const meteredEntitlement = {
    feature_code: 'transcription_minutes',
    feature_name: 'Transcription minutes',
    value: {
      type: 'METERED',
      enabled: true,
      limit: '30',
      consumed: '4.5',
      remaining: '25.5',
      unlimited: false,
      reset_at: '2026-10-01T00:00:00Z',
      reset_period: { type: 'BILLING_CYCLE', interval: null, unit: null },
      metric_code: 'transcription_minutes',
    },
  };

  const validEntitlements = { entitlements: [meteredEntitlement] };

  function entitlementsAreValid(body: unknown): boolean {
    const validate = responseValidator('listEntitlements', 200);
    return validate(body) as boolean;
  }

  it('accepts a well-formed entitlement list', () => {
    expect(entitlementsAreValid(validEntitlements)).toBe(true);
  });

  it('rejects a decimal sent as a JSON number', () => {
    const body = structuredClone(validEntitlements);
    (body.entitlements[0].value as Record<string, unknown>).limit = 30;
    expect(entitlementsAreValid(body)).toBe(false);
  });

  it('rejects an extra property (additionalProperties: false)', () => {
    const body = structuredClone(validEntitlements);
    (body.entitlements[0].value as Record<string, unknown>).extra = 'surprise';
    expect(entitlementsAreValid(body)).toBe(false);
  });

  it('rejects a nullable-but-required property that was omitted rather than nulled', () => {
    const body = structuredClone(validEntitlements);
    delete (body.entitlements[0].value as Record<string, unknown>).metric_code;
    expect(entitlementsAreValid(body)).toBe(false);
  });

  it('rejects an untagged union member', () => {
    const body = structuredClone(validEntitlements);
    delete (body.entitlements[0].value as Record<string, unknown>).type;
    expect(entitlementsAreValid(body)).toBe(false);
  });

  it('rejects a value tagged as one variant but shaped like another', () => {
    const body = structuredClone(validEntitlements);
    (body.entitlements[0].value as Record<string, unknown>).type = 'BOOLEAN';
    expect(entitlementsAreValid(body)).toBe(false);
  });

  it('rejects an error envelope missing the always-present quota key', () => {
    const validate = schemaValidator('Error');
    expect(validate({ code: 'UNAUTHORIZED', message: 'no', quota: null, upgrade_plan_code: null }))
      .toBe(true);
    expect(validate({ code: 'UNAUTHORIZED', message: 'no', upgrade_plan_code: null })).toBe(false);
    expect(validate({ code: 'NOPE', message: 'no', quota: null, upgrade_plan_code: null })).toBe(
      false,
    );
  });

  it('rejects invoice money sent as a decimal string', () => {
    const validate = responseValidator('listInvoices', 200);
    const invoice = {
      id: 'inv_1',
      invoice_number: 'SCR-0001',
      status: 'DRAFT',
      currency: 'USD',
      invoice_date: '2026-09-01',
      due_date: null,
      total: 2900,
      amount_due: 2900,
    };
    expect(validate({ invoices: [invoice] })).toBe(true);
    expect(validate({ invoices: [{ ...invoice, total: '2900' }] })).toBe(false);
  });
});

describe('the suite covers every operation in the contract', () => {
  it('has one helper per operationId, named after it', () => {
    expect(Object.keys(api).sort()).toEqual(Object.keys(operations).sort());
  });

  it('references every helper from at least one test file', () => {
    const sources = readdirSync(TESTS_DIR)
      .filter((file) => file.endsWith('.test.ts'))
      .map((file) => readFileSync(join(TESTS_DIR, file), 'utf8'))
      .join('\n');

    const untested = Object.keys(api).filter((name) => !sources.includes(`api.${name}(`));
    expect(
      untested,
      `these contract operations are never called by the suite: ${untested.join(', ')}`,
    ).toEqual([]);
  });
});

describe('exact decimal arithmetic', () => {
  it('bills minutes by rounding seconds up to two decimals', () => {
    // The same four cases the Rust backend unit-tests, so the two cannot drift.
    expect(billableMinutes(60)).toBe('1');
    expect(billableMinutes(210)).toBe('3.5');
    expect(billableMinutes(100)).toBe('1.67');
    expect(billableMinutes(1)).toBe('0.02');
  });

  it('compares numerically, not textually', () => {
    expect(compareDecimal('1', '1.00')).toBe(0);
    expect(compareDecimal('9', '10')).toBe(-1);
    expect(compareDecimal('0.30', '0.3')).toBe(0);
  });

  it('subtracts and adds without binary floating point', () => {
    // 0.3 - 0.1 is 0.19999999999999998 in IEEE 754. The whole reason the contract keeps
    // decimals as strings is that this must not happen to a quota balance.
    expect(subtractDecimal('0.3', '0.1')).toBe('0.2');
    expect(addDecimal('0.1', '0.2')).toBe('0.3');
    expect(subtractDecimal('30', '29.99')).toBe('0.01');
  });

  it('converts a minute balance back into whole seconds, rounding up', () => {
    expect(secondsForMinutes('1')).toBe(60);
    expect(secondsForMinutes('3.5')).toBe(210);
    expect(secondsForMinutes('1.67')).toBe(101);
  });

  it('refuses to treat a non-decimal string as a number', () => {
    expect(() => compareDecimal('1e3', '1')).toThrow(/not a contract decimal string/);
  });
});

describe('Standard Webhooks signing', () => {
  it('matches the published test vector', () => {
    // From the standardwebhooks reference implementation — the same vector the Rust SDK
    // asserts on. If this passes, the payloads the suite signs are ones the SDK verifier
    // in each backend will accept.
    const signature = signWebhook(
      'whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD',
      'msg_27UH4WbU6Z5A5EzD8u03UvzRbpk',
      1649367553,
      '{"email":"test@example.com","username":"test_user"}',
    );
    expect(signature).toBe('v1,tZ1I4/hDygAJgO5TYxiSd6Sd0kDW6hPenDe+bTa3Kkw=');
  });

  it('signs the exact bytes it sends', () => {
    const request = signedWebhookRequest('whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD', {
      id: 'evt_1',
      type: 'invoice.paid',
    });
    const expected = signWebhook(
      'whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD',
      request.messageId,
      request.timestamp,
      request.payload,
    );
    expect(request.headers['webhook-signature']).toBe(expected);
  });

  it('can emit the svix-* compatibility headers', () => {
    const request = signedWebhookRequest('whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD', {}, {
      headerStyle: 'svix',
    });
    expect(Object.keys(request.headers)).toContain('svix-signature');
    expect(Object.keys(request.headers)).not.toContain('webhook-signature');
  });
});

describe('session tokens', () => {
  it('mints the construction the contract documents', () => {
    const token = mintSessionToken('s3cret', 'scribe-demo-8f2a1c');
    const [version, payload, signature] = token.split('.');
    expect(version).toBe('v1');
    expect(Buffer.from(payload, 'base64url').toString('utf8')).toBe('scribe-demo-8f2a1c');
    expect(signature.length).toBeGreaterThan(0);
    expect(mintSessionToken('s3cret', 'scribe-demo-8f2a1c')).toBe(token);
    expect(mintSessionToken('other', 'scribe-demo-8f2a1c')).not.toBe(token);
  });
});
