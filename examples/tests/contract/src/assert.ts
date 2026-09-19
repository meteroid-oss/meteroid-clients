/**
 * The single assertion every test in this suite goes through.
 *
 * `expectStatus` does four things, in this order, and each of them has caught a real
 * class of bug in a hand-written backend:
 *
 *  1. the status is the one expected;
 *  2. the contract *declares* that status for that operation (an undeclared status is a
 *     conformance failure even when it is otherwise reasonable);
 *  3. the body is JSON with a JSON content type;
 *  4. the body validates against the contract's schema for exactly that
 *     operation + status — `additionalProperties: false` and total `required` lists mean
 *     both a stray field and a missing one fail here.
 */

import { expect } from 'vitest';

import { formatValidationErrors, responseValidator, schemaValidator } from './spec.js';
import type { ScribeResponse } from './http.js';
import type { ErrorCode, ScribeError } from './types.js';

function describeCall(response: ScribeResponse): string {
  return `${response.method} ${response.url} (${response.operationId})`;
}

function shortBody(response: ScribeResponse): string {
  const text = response.text.length > 1500 ? `${response.text.slice(0, 1500)}…` : response.text;
  return text.length > 0 ? text : '(empty body)';
}

/** Validate a response against the contract and return its body, typed by the caller. */
export function expectStatus<T>(response: ScribeResponse, status: number): T {
  expect(
    response.status,
    `${describeCall(response)} should have returned ${status} but returned ${response.status}.\n` +
      `Body: ${shortBody(response)}`,
  ).toBe(status);

  // Throws — with the list of declared statuses — when the contract has no schema here.
  const validate = responseValidator(response.operationId, status);

  expect(
    response.jsonParseError,
    `${describeCall(response)} returned a body that is not JSON: ${response.jsonParseError}\n` +
      `Body: ${shortBody(response)}`,
  ).toBeNull();

  expect(
    response.contentType,
    `${describeCall(response)} must answer with a JSON content type, got ${response.contentType}.`,
  ).toMatch(/^application\/json/);

  const valid = validate(response.body);
  expect(
    valid,
    `${describeCall(response)} returned ${status} with a body that does not match the contract ` +
      `schema for that response:\n${formatValidationErrors(validate.errors, response.body)}`,
  ).toBe(true);

  return response.body as T;
}

/**
 * Validate an error response and assert its machine-readable `code`.
 *
 * The code is what clients switch on, so it is asserted separately from the status: two
 * different failures can share a status (`400` covers both a malformed body and a bad
 * webhook signature) and they must stay distinguishable.
 */
export function expectError(
  response: ScribeResponse,
  status: number,
  code: ErrorCode | ErrorCode[],
): ScribeError {
  const body = expectStatus<ScribeError>(response, status);
  const acceptable = Array.isArray(code) ? code : [code];

  expect(
    acceptable,
    `${describeCall(response)} returned ${status} with code ${body.code}, expected ` +
      `${acceptable.join(' or ')}.\nMessage: ${body.message}`,
  ).toContain(body.code);

  expect(
    body.message.trim().length,
    `${describeCall(response)} returned an error with an empty message. The contract's messages ` +
      `are what an operator reads when something is misconfigured; they must say something.`,
  ).toBeGreaterThan(0);

  assertErrorEnvelopeInvariants(body, describeCall(response));
  return body;
}

/**
 * The two envelope rules that hold for *every* error in the contract, asserted centrally
 * so they are checked on all ~40 error responses this suite provokes rather than on the
 * handful somebody remembered to check.
 *
 *  * `quota` is populated for `QUOTA_EXHAUSTED` and null for everything else.
 *  * `upgrade_plan_code` is null for everything except `QUOTA_EXHAUSTED` and
 *    `FEATURE_NOT_ENTITLED` — where it *may* still be null, since the contract says a
 *    failure to resolve the upsell must never replace the error the caller actually hit.
 */
export function assertErrorEnvelopeInvariants(body: ScribeError, where: string): void {
  if (body.code === 'QUOTA_EXHAUSTED') {
    expect(
      body.quota,
      `${where} returned QUOTA_EXHAUSTED without a quota snapshot. The frontend renders the ` +
        `upgrade prompt straight from this field, so it must be populated.`,
    ).not.toBeNull();
  } else {
    expect(
      body.quota,
      `${where} returned ${body.code} with a populated quota. The contract populates quota only ` +
        `for QUOTA_EXHAUSTED.`,
    ).toBeNull();
  }

  if (body.code !== 'QUOTA_EXHAUSTED' && body.code !== 'FEATURE_NOT_ENTITLED') {
    expect(
      body.upgrade_plan_code,
      `${where} returned ${body.code} with upgrade_plan_code=${body.upgrade_plan_code}. The ` +
        `contract sets it only for QUOTA_EXHAUSTED and FEATURE_NOT_ENTITLED.`,
    ).toBeNull();
  }
}

/**
 * Validate a body against the shared `Error` schema directly, for responses the contract
 * cannot attach to an operation — currently only the `404` from an unmatched route.
 */
export function expectErrorEnvelope(
  response: ScribeResponse,
  status: number,
  code: ErrorCode,
): ScribeError {
  expect(
    response.status,
    `${describeCall(response)} should have returned ${status}.\nBody: ${shortBody(response)}`,
  ).toBe(status);

  const validate = schemaValidator('Error');
  const valid = validate(response.body);
  expect(
    valid,
    `${describeCall(response)} returned ${status} with a body that is not the contract's Error ` +
      `envelope:\n${formatValidationErrors(validate.errors, response.body)}`,
  ).toBe(true);

  const body = response.body as ScribeError;
  expect(body.code, `${describeCall(response)} returned code ${body.code}.`).toBe(code);
  assertErrorEnvelopeInvariants(body, describeCall(response));
  return body;
}

/**
 * Assert one of several acceptable statuses, validating the body against whichever one
 * came back. Used where the contract legitimately allows more than one outcome — a
 * checkout for a plan the workspace already has, for instance.
 */
export function expectOneOfStatuses(response: ScribeResponse, statuses: number[]): number {
  expect(
    statuses,
    `${describeCall(response)} returned ${response.status}, expected one of ` +
      `${statuses.join(', ')}.\nBody: ${shortBody(response)}`,
  ).toContain(response.status);
  expectStatus(response, response.status);
  return response.status;
}
