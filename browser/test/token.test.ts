import assert from "node:assert/strict";
import { afterEach, describe, it, mock } from "node:test";
import { createTokenSource, jwtExpiry, parseTokenResponse } from "../src/token";
import { flush, jwt } from "./helpers";

const EXP = 1_790_000_000; // seconds

describe("parseTokenResponse", () => {
  it("accepts a bare token and reads the expiry from the JWT", () => {
    const token = jwt({ exp: EXP, iat: EXP - 3600 });
    assert.deepEqual(parseTokenResponse(token), {
      token,
      expiresAt: EXP * 1000,
      apiUrl: undefined,
      portalUrl: undefined,
    });
  });

  it("accepts the REST response as-is (snake_case)", () => {
    assert.deepEqual(
      parseTokenResponse({
        token: "tok",
        expires_at: "2026-10-01T00:00:00Z",
        api_url: "http://localhost:8084",
        portal_url: "http://localhost:5173",
        portal_link: "http://localhost:5173/portal/customer?token=tok",
      }),
      {
        token: "tok",
        expiresAt: Date.parse("2026-10-01T00:00:00Z"),
        apiUrl: "http://localhost:8084",
        portalUrl: "http://localhost:5173",
      }
    );
  });

  it("accepts the @meteroid/sdk response (camelCase, Date expiry)", () => {
    const expiresAt = new Date("2026-10-01T00:00:00Z");
    assert.deepEqual(
      parseTokenResponse({
        token: "tok",
        expiresAt,
        apiUrl: "https://api.example",
        portalUrl: "https://portal.example",
      }),
      {
        token: "tok",
        expiresAt: expiresAt.getTime(),
        apiUrl: "https://api.example",
        portalUrl: "https://portal.example",
      }
    );
  });

  it("prefers the response's expiry over the JWT's", () => {
    const token = jwt({ exp: EXP });
    const parsed = parseTokenResponse({ token, expires_at: "2026-10-01T00:00:00Z" });
    assert.equal(parsed.expiresAt, Date.parse("2026-10-01T00:00:00Z"));
    assert.equal(
      parseTokenResponse({ token, expires_at: "garbage" }).expiresAt,
      EXP * 1000
    );
  });

  it("rejects anything that carries no token", () => {
    for (const value of [undefined, null, "", {}, { token: 1 }, { access_token: "x" }]) {
      assert.throws(() => parseTokenResponse(value), TypeError);
    }
  });
});

describe("jwtExpiry", () => {
  it("decodes base64url payloads", () => {
    // "~~~" encodes to "fn5-" in base64url: the "-" must be mapped back.
    assert.equal(jwtExpiry(jwt({ exp: EXP, x: "~~~" })), EXP * 1000);
  });

  it("returns undefined when there is no usable exp", () => {
    assert.equal(jwtExpiry("opaque-token"), undefined);
    assert.equal(jwtExpiry("a.%%%.c"), undefined);
    assert.equal(jwtExpiry(jwt({ iat: EXP })), undefined);
  });
});

describe("token lifecycle", () => {
  afterEach(() => mock.timers.reset());

  function source(expiresInMs: (call: number) => number | undefined) {
    let clock = 1_000_000;
    let calls = 0;
    const getToken = async () => {
      calls += 1;
      const ttl = expiresInMs(calls);
      return {
        token: `tok_${calls}`,
        expires_at: ttl === undefined ? null : new Date(clock + ttl).toISOString(),
      };
    };
    const tokens = createTokenSource(getToken, () => clock);
    return {
      tokens,
      calls: () => calls,
      advance: (ms: number) => {
        clock += ms;
      },
    };
  }

  it("fetches once for concurrent callers", async () => {
    const { tokens, calls } = source(() => 3_600_000);
    const results = await Promise.all([tokens.get(), tokens.get(), tokens.get()]);
    assert.equal(calls(), 1);
    assert.deepEqual(
      results.map((r) => r.token),
      ["tok_1", "tok_1", "tok_1"]
    );
  });

  it("reuses the token until 60 s before it expires", async () => {
    const { tokens, calls, advance } = source(() => 3_600_000);
    await tokens.get();
    advance(3_600_000 - 61_000);
    assert.equal((await tokens.get()).token, "tok_1");
    advance(2_000);
    assert.equal((await tokens.get()).token, "tok_2");
    assert.equal(calls(), 2);
  });

  it("refreshes short-lived tokens at half their lifetime", async () => {
    const { tokens, advance } = source(() => 60_000);
    await tokens.get();
    advance(29_000);
    assert.equal((await tokens.get()).token, "tok_1");
    advance(1_000);
    assert.equal((await tokens.get()).token, "tok_2");
  });

  it("keeps a still-valid token when fetching the next one fails", async () => {
    let fail = false;
    let clock = 0;
    const tokens = createTokenSource(
      async () => {
        if (fail) throw new Error("backend down");
        return { token: "tok", expires_at: new Date(clock + 3_600_000).toISOString() };
      },
      () => clock
    );
    await tokens.get();
    fail = true;
    clock = 3_600_000 - 30_000;
    assert.equal((await tokens.get()).token, "tok");
    clock = 3_600_000;
    await assert.rejects(tokens.get(), /backend down/);
  });

  it("ignores an expiry that is already past, instead of refetching on every call", async () => {
    const { tokens, calls } = source(() => -5_000);
    await tokens.get();
    await tokens.get();
    assert.equal(calls(), 1);
  });

  it("refresh() replaces a stale token once", async () => {
    const { tokens, calls } = source(() => 3_600_000);
    const first = await tokens.get();
    const [a, b] = await Promise.all([
      tokens.refresh(first.token),
      tokens.refresh(first.token),
    ]);
    assert.equal(a.token, "tok_2");
    assert.equal(b.token, "tok_2");
    // A caller still holding the first token gets the new one without a fetch.
    assert.equal((await tokens.refresh(first.token)).token, "tok_2");
    assert.equal(calls(), 2);
  });

  it("refresh() does not hand out a newer token that is itself expired", async () => {
    const { tokens, advance } = source(() => 3_600_000);
    const first = await tokens.get();
    advance(3_600_000);
    await tokens.get();
    // An embed still on the first token reports it expired hours later.
    advance(4 * 3_600_000);
    assert.equal((await tokens.refresh(first.token)).token, "tok_3");
  });

  it("keepFresh() fetches ahead of expiry, only while enabled", async () => {
    mock.timers.enable({ apis: ["setTimeout"] });
    const { tokens, calls, advance } = source(() => 600_000);
    tokens.keepFresh(true);
    await tokens.get();

    advance(540_000);
    mock.timers.tick(540_000);
    await flush();
    assert.equal(calls(), 2);

    tokens.keepFresh(false);
    advance(600_000);
    mock.timers.tick(600_000);
    await flush();
    assert.equal(calls(), 2);
  });

  it("does not schedule beyond the timer range (30-day tokens)", async () => {
    // Real timers: an overflowing delay would fire after 1 ms.
    const { tokens, calls } = source(() => 30 * 24 * 3_600_000);
    tokens.keepFresh(true);
    await tokens.get();
    await new Promise((resolve) => setTimeout(resolve, 20));
    tokens.keepFresh(false);
    assert.equal(calls(), 1);
  });
});
