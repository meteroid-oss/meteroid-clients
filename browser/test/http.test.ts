import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { ApiException } from "../src/errors";
import { createHttp, type HttpOptions } from "../src/http";
import { ErrorCode } from "../src/models/errorCode";
import { createTokenSource, type TokenResponse } from "../src/token";
import { json } from "./helpers";

type Reply = Response | (() => Response);

function setup(
  replies: Reply[],
  options: HttpOptions = {},
  token: Partial<TokenResponse> = {}
) {
  const urls: string[] = [];
  const inits: RequestInit[] = [];
  let tokenCalls = 0;
  const tokens = createTokenSource(async () => {
    tokenCalls += 1;
    return { token: `tok_${tokenCalls}`, ...token };
  });
  const fetchImpl = (async (input: string, init: RequestInit) => {
    urls.push(input);
    inits.push(init);
    const reply = replies[Math.min(urls.length, replies.length) - 1];
    return typeof reply === "function" ? reply() : reply.clone();
  }) as unknown as typeof fetch;
  const get = createHttp(tokens, { fetch: fetchImpl, ...options });
  return { get, urls, inits, tokenCalls: () => tokenCalls };
}

const identity = (x: any) => x;
const expired = () => json(401, { code: "TOKEN_EXPIRED", message: "token expired" });

describe("client API requests", () => {
  it("sends only the authorization header to {apiUrl}/api/client/v1", async () => {
    const { get, urls, inits } = setup([json(200, { ok: true })], {
      apiUrl: "http://localhost:8084/",
    });
    assert.deepEqual(await get("/customer", identity), { ok: true });
    assert.deepEqual(urls, ["http://localhost:8084/api/client/v1/customer"]);
    assert.deepEqual(inits[0], { headers: { authorization: "Bearer tok_1" } });
  });

  it("uses the token's api_url unless apiUrl is set, then the default", async () => {
    const fromToken = setup([json(200, {})], {}, { api_url: "https://eu.example" });
    await fromToken.get("/customer", identity);
    assert.equal(fromToken.urls[0], "https://eu.example/api/client/v1/customer");

    const explicit = setup(
      [json(200, {})],
      { apiUrl: "https://mine.example" },
      { api_url: "https://eu.example" }
    );
    await explicit.get("/customer", identity);
    assert.equal(explicit.urls[0], "https://mine.example/api/client/v1/customer");

    const fallback = setup([json(200, {})]);
    await fallback.get("/customer", identity);
    assert.equal(fallback.urls[0], "https://api.meteroid.com/api/client/v1/customer");
  });

  it("retries once with a new token after 401 TOKEN_EXPIRED", async () => {
    const { get, inits, tokenCalls } = setup([expired(), json(200, { ok: true })]);
    assert.deepEqual(await get("/entitlements", identity), { ok: true });
    assert.equal(tokenCalls(), 2);
    assert.deepEqual(
      inits.map((i) => (i.headers as Record<string, string>).authorization),
      ["Bearer tok_1", "Bearer tok_2"]
    );
  });

  it("gives up after a second TOKEN_EXPIRED", async () => {
    const { get, urls } = setup([expired()]);
    const error = await get("/entitlements", identity).catch((e) => e);
    assert.ok(error instanceof ApiException);
    assert.equal(error.restError?.code, ErrorCode.TokenExpired);
    assert.equal(urls.length, 2);
  });

  it("does not retry other 401s", async () => {
    const { get, urls, tokenCalls } = setup([
      json(401, { code: "UNAUTHORIZED", message: "bad token" }),
    ]);
    const error = await get("/customer", identity).catch((e) => e);
    assert.equal(error.status, 401);
    assert.equal(error.restError?.code, ErrorCode.Unauthorized);
    assert.equal(urls.length, 1);
    assert.equal(tokenCalls(), 1);
  });

  it("waits for Retry-After after a 429, then retries once", async () => {
    let clock = 0;
    const sleeps: number[] = [];
    const { get, urls } = setup(
      [
        json(
          429,
          { code: "TOO_MANY_REQUESTS", message: "slow down" },
          { "retry-after": "3" }
        ),
        json(200, { ok: true }),
      ],
      {
        now: () => clock,
        sleep: async (ms) => {
          sleeps.push(ms);
          clock += ms;
        },
      }
    );
    assert.deepEqual(await get("/customer", identity), { ok: true });
    assert.deepEqual(sleeps, [3000]);
    assert.equal(urls.length, 2);
  });

  it("holds the following requests until Retry-After has passed", async () => {
    let clock = 0;
    const sleeps: number[] = [];
    const tooMany = () =>
      json(429, { code: "TOO_MANY_REQUESTS", message: "x" }, { "retry-after": "10" });
    const { get } = setup([tooMany(), tooMany(), json(200, {})], {
      now: () => clock,
      sleep: async (ms) => {
        sleeps.push(ms);
        clock += 4000;
      },
    });
    await assert.rejects(get("/customer", identity), ApiException);
    await get("/customer", identity);
    assert.deepEqual(sleeps, [10_000, 6000]);
  });

  it("reads an HTTP-date Retry-After and caps long waits", async () => {
    const sleeps: number[] = [];
    const clock = Date.parse("2026-09-24T10:00:00Z");
    const run = async (retryAfter: string) => {
      const { get } = setup(
        [json(429, {}, { "retry-after": retryAfter }), json(200, {})],
        { now: () => clock, sleep: async (ms) => void sleeps.push(ms) }
      );
      await get("/customer", identity);
    };
    await run("Thu, 24 Sep 2026 10:00:05 GMT");
    await run("86400");
    await run("soon");
    assert.deepEqual(sleeps, [5000, 60_000, 1000]);
  });

  it("throws an ApiException with the raw body when the error is not JSON", async () => {
    const { get } = setup([new Response("<html>bad gateway</html>", { status: 502 })]);
    const error = await get("/customer", identity).catch((e) => e);
    assert.ok(error instanceof ApiException);
    assert.equal(error.status, 502);
    assert.equal(error.body, "<html>bad gateway</html>");
    assert.equal(error.restError, undefined);
    assert.equal(error.message, "API Error 502");
  });
});
