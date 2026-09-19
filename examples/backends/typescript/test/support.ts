/**
 * Shared fixtures for the offline tests.
 *
 * Nothing here opens a socket. The router is a pure function, so the tests call it
 * directly; and the SDK takes a custom `fetch`, so "Meteroid" is a function that either
 * answers from a table or fails the test for having been called at all.
 */

import assert from "node:assert/strict";

import { Currency, Meteroid, Webhook } from "@meteroid/sdk";

import { router } from "../src/app.js";
import type { Config } from "../src/config.js";
import { AppState } from "../src/state.js";

/** Any base64 string is a valid Standard Webhooks secret. */
export const WEBHOOK_SECRET = "c2NyaWJlLWRlbW8td2ViaG9vay1zZWNyZXQ=";
export const SESSION_SECRET = "test-session-secret";

export const CONFIG: Config = {
  // No API key: every Meteroid-backed operation is out of scope unless a test stubs it.
  meteroidApiKey: "",
  meteroidBaseUrl: "http://meteroid.invalid",
  meteroidWebhookSecret: WEBHOOK_SECRET,
  sessionSecret: SESSION_SECRET,
  defaultCurrency: Currency.Usd,
  port: 0,
};

/** One stubbed Meteroid answer: a JSON body, or a function of the request producing one. */
export type Stub = unknown | ((request: { url: URL; body: unknown }) => unknown);

export interface FakeMeteroid {
  client: Meteroid;
  /** Every request the SDK made, as `"METHOD /path"`. */
  calls: string[];
  /** The parsed JSON body of each request, in the same order. */
  bodies: unknown[];
}

/**
 * A Meteroid client whose `fetch` answers from `routes` (keyed `"METHOD /path"`). A
 * request with no stub is a `404` in Meteroid's own error envelope.
 */
export function fakeMeteroid(routes: Record<string, Stub> = {}): FakeMeteroid {
  const calls: string[] = [];
  const bodies: unknown[] = [];

  const fetch: typeof globalThis.fetch = async (input, init) => {
    const url = new URL(String(input));
    const key = `${init?.method ?? "GET"} ${url.pathname}`;
    const body = typeof init?.body === "string" ? (JSON.parse(init.body) as unknown) : undefined;
    calls.push(key);
    bodies.push(body);

    const stub = routes[key];
    if (stub === undefined) {
      return Response.json({ code: "NOT_FOUND", message: `no stub for ${key}` }, { status: 404 });
    }
    return Response.json(typeof stub === "function" ? stub({ url, body }) : stub);
  };

  return {
    client: new Meteroid("test-key", { serverUrl: "http://meteroid.test", fetch, numRetries: 0 }),
    calls,
    bodies,
  };
}

export interface TestResponse {
  status: number;
  headers: Record<string, string>;
  /** `any` on purpose: the tests index into whatever shape the operation answers with. */
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  body: any;
}

export interface SendOptions {
  headers?: Record<string, string>;
  body?: string | Buffer | null;
  meteroid?: Meteroid;
  state?: AppState;
}

export async function send(
  method: string,
  target: string,
  options: SendOptions = {},
): Promise<TestResponse> {
  const state = options.state ?? new AppState(CONFIG, options.meteroid ?? fakeMeteroid().client);
  const url = new URL(target, "http://localhost");
  const body = options.body === undefined ? "" : options.body;

  const response = await router(state)({
    method,
    path: url.pathname,
    query: url.searchParams,
    headers: options.headers ?? {},
    body: body === null ? null : Buffer.from(body),
  });
  return {
    status: response.status,
    headers: response.headers,
    body: response.body === "" ? null : JSON.parse(response.body),
  };
}

/**
 * Every error in the contract is the same envelope, with `quota` and
 * `upgrade_plan_code` always present — never absent, `null` when they do not apply.
 */
export function assertErrorEnvelope(body: unknown, code: string): void {
  assert.ok(typeof body === "object" && body !== null, `not an object: ${JSON.stringify(body)}`);
  assert.deepEqual(Object.keys(body).sort(), ["code", "message", "quota", "upgrade_plan_code"]);
  const envelope = body as Record<string, unknown>;
  assert.equal(envelope["code"], code, JSON.stringify(body));
  assert.equal(typeof envelope["message"], "string");
}

/** Sign a payload exactly the way Meteroid does, using the SDK's own signer. */
export function signed(payload: string, msgId: string, prefix = "webhook"): Record<string, string> {
  const now = new Date();
  return {
    "content-type": "application/json",
    [`${prefix}-id`]: msgId,
    [`${prefix}-timestamp`]: String(Math.floor(now.getTime() / 1000)),
    [`${prefix}-signature`]: new Webhook(WEBHOOK_SECRET).sign(msgId, now, payload),
  };
}
