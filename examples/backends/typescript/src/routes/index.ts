/**
 * One module per group of operations in `examples/openapi.yaml`.
 *
 * Each handler is deliberately shaped the same way: parse and validate the request,
 * make **one obvious Meteroid SDK call**, then project the result onto the contract's
 * wire type. The SDK call is the line worth reading.
 */

import { ApiError } from "../error.js";
import { rawBody, type Reply, type ScribeRequest } from "../http.js";
import type { AppState } from "../state.js";

export type Handler = (state: AppState, request: ScribeRequest) => Promise<Reply<unknown>>;

/**
 * Parse a **required** JSON request body, with `decode` doing what `JSON.parse` does
 * not: checking it against the contract's schema. Every failure is the contract's
 * `400` envelope.
 */
export function jsonBody<T>(request: ScribeRequest, decode: (json: unknown) => T): T {
  const body = rawBody(request);
  if (body.length === 0) {
    throw ApiError.badRequest("A JSON request body is required.");
  }
  return decode(parseJson(body));
}

/**
 * Parse an **optional** JSON request body.
 *
 * The contract states that for these operations no body, an empty body, `{}` and
 * `{"field": null}` all mean the same thing: use the defaults. That rule is literally
 * this function.
 */
export function optionalJsonBody<T>(request: ScribeRequest, decode: (json: unknown) => T): T {
  const body = rawBody(request);
  return decode(body.every(isAsciiWhitespace) ? {} : parseJson(body));
}

function parseJson(body: Buffer): unknown {
  try {
    // `fatal` so that invalid UTF-8 is an error instead of U+FFFD, and `ignoreBOM` so
    // that a byte-order mark reaches `JSON.parse` and is refused there.
    const text = new TextDecoder("utf-8", { fatal: true, ignoreBOM: true }).decode(body);
    return JSON.parse(text) as unknown;
  } catch (err) {
    throw ApiError.badRequest(`Invalid body: ${err instanceof Error ? err.message : String(err)}`);
  }
}

function isAsciiWhitespace(byte: number): boolean {
  return byte === 0x20 || byte === 0x09 || byte === 0x0a || byte === 0x0c || byte === 0x0d;
}

/**
 * `404` for an unmatched route, in the standard envelope. No operation in the contract
 * takes a path parameter, so this only ever fires on a typo.
 */
export function notFound(): ApiError {
  return new ApiError(
    "NOT_FOUND",
    "No such endpoint. See examples/openapi.yaml for the operations this demo serves.",
  );
}

/** Trim a string field and reject it when it is empty or too long. */
export function bounded(field: string, value: string, max: number): string {
  const trimmed = value.trim();
  if (trimmed === "") {
    throw ApiError.badRequest(`${field} must not be empty.`);
  }
  // Code points, not UTF-16 units: an emoji is one character of the limit, not two.
  if (Array.from(trimmed).length > max) {
    throw ApiError.badRequest(`${field} must be at most ${max} characters.`);
  }
  return trimmed;
}
