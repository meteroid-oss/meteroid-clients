/**
 * The HTTP layer. Method and path come from the contract, never from a string literal
 * in a test, so a renamed path is a spec edit and not a suite edit.
 */

import { BASE_URL, REQUEST_TIMEOUT_MS } from './env.js';
import { operation } from './spec.js';

export interface ScribeResponse {
  operationId: string;
  method: string;
  url: string;
  status: number;
  headers: Headers;
  contentType: string | null;
  /** The raw response body, exactly as it came off the wire. */
  text: string;
  /** `text` parsed as JSON, or `undefined` when it was not JSON. */
  body: unknown;
  jsonParseError: string | null;
}

export interface RequestOptions {
  /** `Authorization: Bearer <token>`. Omit for the unauthenticated operations. */
  token?: string;
  /** JSON request body. Omit to send no body at all — which several operations allow. */
  body?: unknown;
  /**
   * Body bytes to send verbatim, bypassing `JSON.stringify`. The webhook tests need
   * this: a signature covers the exact bytes, so re-serializing would invalidate it.
   */
  rawBody?: string;
  query?: Record<string, string | number | undefined>;
  headers?: Record<string, string>;
  /** Send an `Authorization` header with no `Bearer ` prefix (a 401 test). */
  rawAuthorization?: string;
}

/**
 * Raised when the backend could not be reached at all, as distinct from a backend that
 * answered something wrong. Every "no server running" failure in this suite is one of
 * these, and says so.
 */
export class BackendUnreachableError extends Error {
  constructor(url: string, cause: unknown) {
    super(
      `Cannot reach ${url}.\n` +
        `BASE_URL is ${BASE_URL} — is a Scribe backend listening there?\n` +
        `Start one first (see tests/contract/README.md), then re-run.\n` +
        `Underlying error: ${cause instanceof Error ? cause.message : String(cause)}`,
    );
    this.name = 'BackendUnreachableError';
    this.cause = cause;
  }
}

function buildUrl(path: string, query: RequestOptions['query']): string {
  const url = new URL(`${BASE_URL}${path}`);
  for (const [key, value] of Object.entries(query ?? {})) {
    if (value !== undefined) url.searchParams.set(key, String(value));
  }
  return url.toString();
}

export async function request(
  operationId: string,
  options: RequestOptions = {},
): Promise<ScribeResponse> {
  const op = operation(operationId);
  return send(operationId, op.method.toUpperCase(), op.path, options);
}

/**
 * A request to a path the contract does not describe.
 *
 * Only used to prove that an unmatched route still answers in the shared error envelope
 * (`404 NOT_FOUND`), which the contract requires but cannot attach to an operation.
 */
export function rawRequest(
  method: string,
  path: string,
  options: RequestOptions = {},
): Promise<ScribeResponse> {
  return send(`(unrouted ${method} ${path})`, method.toUpperCase(), path, options);
}

async function send(
  operationId: string,
  method: string,
  path: string,
  options: RequestOptions,
): Promise<ScribeResponse> {
  const url = buildUrl(path, options.query);

  const headers: Record<string, string> = { accept: 'application/json', ...options.headers };
  if (options.token) headers.authorization = `Bearer ${options.token}`;
  if (options.rawAuthorization !== undefined) headers.authorization = options.rawAuthorization;

  let payload: string | undefined;
  if (options.rawBody !== undefined) {
    payload = options.rawBody;
  } else if (options.body !== undefined) {
    payload = JSON.stringify(options.body);
  }
  if (payload !== undefined && headers['content-type'] === undefined) {
    headers['content-type'] = 'application/json';
  }

  let response: Response;
  try {
    response = await fetch(url, {
      method,
      headers,
      body: payload,
      signal: AbortSignal.timeout(REQUEST_TIMEOUT_MS),
    });
  } catch (cause) {
    throw new BackendUnreachableError(url, cause);
  }

  const text = await response.text();
  let body: unknown;
  let jsonParseError: string | null = null;
  if (text.length > 0) {
    try {
      body = JSON.parse(text);
    } catch (error) {
      jsonParseError = error instanceof Error ? error.message : String(error);
    }
  }

  return {
    operationId,
    method,
    url,
    status: response.status,
    headers: response.headers,
    contentType: response.headers.get('content-type'),
    text,
    body,
    jsonParseError,
  };
}
