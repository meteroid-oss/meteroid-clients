/**
 * End-to-end checks that need no Meteroid tenant.
 *
 * Everything reachable without an API key is exercised here against the shapes
 * `examples/openapi.yaml` promises: the health probe, the session-token gate, the error
 * envelope, the 404 fallback, and — the interesting one — webhook signature
 * verification, which works offline because the SDK ships a *signer* as well as a
 * verifier. The contract suite uses the same trick to test the receiver for real.
 */

import assert from "node:assert/strict";
import { test } from "node:test";

import { MAX_BODY_BYTES } from "../src/http.js";
import { mint } from "../src/session.js";
import { AppState } from "../src/state.js";
import { assertErrorEnvelope, CONFIG, fakeMeteroid, SESSION_SECRET, send, signed } from "./support.js";

const bearer = (alias = "scribe-demo-1") => ({
  authorization: `Bearer ${mint(SESSION_SECRET, alias)}`,
  "content-type": "application/json",
});

test("health reports the backend and its configuration", async () => {
  const { status, body } = await send("GET", "/api/health");

  assert.equal(status, 200);
  assert.deepEqual(Object.keys(body).sort(), ["backend", "meteroid_configured", "status", "version"]);
  assert.equal(body.status, "ok");
  assert.equal(body.backend, "typescript");
  assert.equal(body.meteroid_configured, false);
  assert.equal(typeof body.version, "string");
});

test("a missing session token is 401 in the standard envelope", async () => {
  const { status, body } = await send("GET", "/api/me");

  assert.equal(status, 401);
  assertErrorEnvelope(body, "UNAUTHORIZED");
});

test("a token from another deployment is rejected", async () => {
  const forged = mint("some-other-secret", "scribe-demo-1");
  const { status, body } = await send("GET", "/api/me", {
    headers: { authorization: `Bearer ${forged}` },
  });

  assert.equal(status, 401);
  assertErrorEnvelope(body, "UNAUTHORIZED");
});

test("an Authorization header that is not a bearer token is rejected", async () => {
  for (const authorization of ["Basic abc", `bearer ${mint(SESSION_SECRET, "a")}`, "Bearer ", "Bearer garbage"]) {
    const { status, body } = await send("GET", "/api/me", { headers: { authorization } });

    assert.equal(status, 401, authorization);
    assertErrorEnvelope(body, "UNAUTHORIZED");
  }
});

test("the session token is checked before the body is looked at", async () => {
  const { status, body } = await send("POST", "/api/transcriptions", { body: "{not json" });

  assert.equal(status, 401);
  assertErrorEnvelope(body, "UNAUTHORIZED");
});

test("an unknown route is 404 in the standard envelope", async () => {
  for (const path of ["/api/nope", "/", "/api/health/", "/api/__proto__"]) {
    const { status, body } = await send("GET", path);

    assert.equal(status, 404, path);
    assertErrorEnvelope(body, "NOT_FOUND");
  }
});

test("a known route with the wrong method is a bare 405 naming what is allowed", async () => {
  const wrong = await send("DELETE", "/api/health");
  assert.equal(wrong.status, 405);
  assert.equal(wrong.headers["allow"], "GET,HEAD");
  assert.equal(wrong.body, null);

  const both = await send("PUT", "/api/transcriptions");
  assert.equal(both.headers["allow"], "GET,HEAD,POST");
});

test("every answer carries permissive CORS headers, and OPTIONS is a preflight", async () => {
  const simple = await send("GET", "/api/nope");
  assert.equal(simple.headers["access-control-allow-origin"], "*");

  const preflight = await send("OPTIONS", "/api/checkout", {
    headers: { origin: "http://localhost:5173", "access-control-request-method": "POST" },
  });
  assert.equal(preflight.status, 200);
  assert.equal(preflight.headers["access-control-allow-origin"], "*");
  assert.equal(preflight.headers["access-control-allow-methods"], "*");
  assert.equal(preflight.headers["access-control-allow-headers"], "*");
});

test("a malformed body is 400 in the standard envelope", async () => {
  const bodies = [
    // `duration_seconds` is required, and unknown fields are rejected.
    '{"title":"x","surprise":true}',
    '{"title":"x"}',
    "{not json",
    "[]",
    "null",
    "",
    "   ",
    // Wrong scalar types are type errors, never coerced.
    '{"title":123,"duration_seconds":60}',
    '{"title":"x","duration_seconds":"60"}',
    '{"title":"x","duration_seconds":60.5}',
    '{"title":"x","duration_seconds":true}',
    '{"title":null,"duration_seconds":60}',
    // Well-typed, but outside the contract's bounds.
    '{"title":"x","duration_seconds":0}',
    '{"title":"x","duration_seconds":7201}',
    '{"title":"   ","duration_seconds":60}',
    `{"title":"${"x".repeat(201)}","duration_seconds":60}`,
  ];
  for (const raw of bodies) {
    const meteroid = fakeMeteroid();
    const { status, body } = await send("POST", "/api/transcriptions", {
      headers: bearer(),
      body: raw,
      meteroid: meteroid.client,
    });

    assert.equal(status, 400, raw);
    assertErrorEnvelope(body, "BAD_REQUEST");
    assert.deepEqual(meteroid.calls, [], `Meteroid was called for ${raw}`);
  }
});

test("a body that is not valid UTF-8 is 400, not a replacement character", async () => {
  const { status, body } = await send("POST", "/api/session", {
    body: Buffer.from([0x7b, 0x22, 0xff, 0x22, 0x3a, 0x31, 0x7d]),
  });

  assert.equal(status, 400);
  assertErrorEnvelope(body, "BAD_REQUEST");
});

test("an optional body rejects what it does not declare", async () => {
  for (const raw of ['{"nope":1}', '{"workspace_name":123}', '{"workspace_name":"  "}', '{"email":false}', "[]"]) {
    const meteroid = fakeMeteroid();
    const { status, body } = await send("POST", "/api/session", { body: raw, meteroid: meteroid.client });

    assert.equal(status, 400, raw);
    assertErrorEnvelope(body, "BAD_REQUEST");
    assert.deepEqual(meteroid.calls, []);
  }
});

test("a plan code outside the contract enum is rejected before the catalog is consulted", async () => {
  const meteroid = fakeMeteroid();
  const { status, body } = await send("POST", "/api/checkout", {
    headers: bearer(),
    body: '{"plan_code":"gold"}',
    meteroid: meteroid.client,
  });

  assert.equal(status, 400);
  assertErrorEnvelope(body, "BAD_REQUEST");
  assert.deepEqual(meteroid.calls, []);
});

test("an out-of-range portal lifetime is rejected before Meteroid sees it", async () => {
  for (const raw of ['{"expires_in_seconds":5}', '{"expires_in_seconds":2592001}', '{"expires_in_seconds":"60"}']) {
    const meteroid = fakeMeteroid();
    const { status, body } = await send("POST", "/api/portal-session", {
      headers: bearer(),
      body: raw,
      meteroid: meteroid.client,
    });

    assert.equal(status, 400, raw);
    assertErrorEnvelope(body, "BAD_REQUEST");
    assert.deepEqual(meteroid.calls, []);
  }
});

test("an invalid invoice limit is rejected before Meteroid sees it", async () => {
  for (const query of ["limit=0", "limit=101", "limit=abc", "limit=", "limit=1.5", "foo=1", "limit=1&limit=2"]) {
    const meteroid = fakeMeteroid();
    const { status, body } = await send("GET", `/api/invoices?${query}`, {
      headers: bearer(),
      meteroid: meteroid.client,
    });

    assert.equal(status, 400, query);
    assertErrorEnvelope(body, "BAD_REQUEST");
    assert.deepEqual(meteroid.calls, []);
  }
});

test("an oversized body is refused in the standard envelope", async () => {
  // `null` is how `http.ts` reports a body it stopped buffering at the limit.
  const { status, body } = await send("POST", "/api/session", { body: null });

  assert.equal(status, 413);
  assertErrorEnvelope(body, "BAD_REQUEST");
  assert.ok(MAX_BODY_BYTES > 0);
});

test("an unreachable Meteroid is 502, not a crash", async () => {
  // No fake here: the real client, pointed at a port nothing listens on.
  const state = new AppState({ ...CONFIG, meteroidBaseUrl: "http://127.0.0.1:9" });
  const { status, body } = await send("GET", "/api/plans", { state });

  assert.equal(status, 502);
  assertErrorEnvelope(body, "UPSTREAM_ERROR");
});

// ---------------------------------------------------------------- webhooks

test("a correctly signed event is accepted", async () => {
  const payload = JSON.stringify({ id: "evt_123", type: "invoice.paid", timestamp: "2026-09-01T12:00:00Z" });
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_1"),
    body: payload,
  });

  assert.equal(status, 202);
  assert.deepEqual(body, { received: true, event_id: "evt_123", type: "invoice.paid", handled: true });
});

test("the raw bytes are verified, not a re-serialization of them", async () => {
  // Spacing and key order no JSON serializer would reproduce.
  const payload = '{ "type" : "invoice.paid",\n\t"id":"evt_raw"   }';
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_raw"),
    body: payload,
  });

  assert.equal(status, 202);
  assert.equal(body.event_id, "evt_raw");
});

test("an unknown event type is acknowledged, not rejected", async () => {
  // A receiver that 400s on an unrecognized type breaks the first time Meteroid ships a
  // new one — so this must be a 202 with `handled: false`. The body also carries no
  // `timestamp`, which must not matter either.
  const payload = JSON.stringify({ id: "evt_9", type: "something.invented.later" });
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_9"),
    body: payload,
  });

  assert.equal(status, 202);
  assert.equal(body.handled, false);
  assert.equal(body.event_id, "evt_9");
});

test("a signed body of an unexpected shape is acknowledged too", async () => {
  for (const payload of ["[1,2]", '{"id":7,"type":["x"]}', '"just a string"']) {
    const { status, body } = await send("POST", "/api/webhooks/meteroid", {
      headers: signed(payload, "msg_shape"),
      body: payload,
    });

    assert.equal(status, 202, payload);
    assert.deepEqual(body, { received: true, event_id: "msg_shape", type: null, handled: false });
  }
});

test("an event with no id falls back to the webhook-id header", async () => {
  const payload = JSON.stringify({ type: "subscription.created" });
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_42"),
    body: payload,
  });

  assert.equal(status, 202);
  assert.equal(body.event_id, "msg_42");
  assert.equal(body.handled, true);
});

test("svix headers are accepted as aliases", async () => {
  const payload = JSON.stringify({ type: "invoice.finalized" });
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_s", "svix"),
    body: payload,
  });

  assert.equal(status, 202);
  // The id fallback has to follow the alias as well.
  assert.equal(body.event_id, "msg_s");
});

test("a body that does not match its signature is rejected", async () => {
  const payload = JSON.stringify({ id: "evt_1", type: "invoice.paid" });
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: signed(payload, "msg_1"),
    // One field different from what was signed.
    body: JSON.stringify({ id: "evt_1", type: "invoice.void" }),
  });

  assert.equal(status, 400);
  assertErrorEnvelope(body, "WEBHOOK_SIGNATURE_INVALID");
});

test("a stale timestamp is rejected", async () => {
  const payload = JSON.stringify({ type: "invoice.paid" });
  const headers = signed(payload, "msg_old");
  headers["webhook-timestamp"] = String(Math.floor(Date.now() / 1000) - 3600);
  const { status, body } = await send("POST", "/api/webhooks/meteroid", { headers, body: payload });

  assert.equal(status, 400);
  assertErrorEnvelope(body, "WEBHOOK_SIGNATURE_INVALID");
});

test("an unsigned event is rejected", async () => {
  const { status, body } = await send("POST", "/api/webhooks/meteroid", {
    headers: { "content-type": "application/json" },
    body: '{"type":"invoice.paid"}',
  });

  assert.equal(status, 400);
  assertErrorEnvelope(body, "WEBHOOK_SIGNATURE_INVALID");
});

test("a correctly signed body that is not JSON is rejected", async () => {
  for (const payload of ["not json", ""]) {
    const { status, body } = await send("POST", "/api/webhooks/meteroid", {
      headers: signed(payload, "msg_nj"),
      body: payload,
    });

    assert.equal(status, 400, JSON.stringify(payload));
    assertErrorEnvelope(body, "WEBHOOK_SIGNATURE_INVALID");
  }
});

test("a missing webhook secret is the operator's problem, not a bad signature", async () => {
  const state = new AppState({ ...CONFIG, meteroidWebhookSecret: "" }, fakeMeteroid().client);
  const { status, body } = await send("POST", "/api/webhooks/meteroid", { state, body: "{}" });

  assert.equal(status, 500);
  assertErrorEnvelope(body, "INTERNAL");
});
