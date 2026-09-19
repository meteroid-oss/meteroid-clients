import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { Webhook, WebhookVerificationError } from "../src/webhook";

// The same fixture the Rust tests use (`rust/src/webhooks.rs`).
const SECRET = "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD";
const PAYLOAD = '{"test": "data"}';
const MSG_ID = "msg_test123";

function sign(): { webhook: Webhook; signature: string; timestamp: string } {
  const webhook = new Webhook(SECRET);
  const now = new Date();
  return {
    webhook,
    signature: webhook.sign(MSG_ID, now, PAYLOAD),
    timestamp: Math.floor(now.getTime() / 1000).toString(),
  };
}

describe("Webhook.verify", () => {
  it("accepts Standard Webhooks (webhook-*) headers", () => {
    const { webhook, signature, timestamp } = sign();

    const event = webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
    });

    assert.deepEqual(event, { test: "data" });
  });

  it("accepts Svix (svix-*) headers", () => {
    const { webhook, signature, timestamp } = sign();

    const event = webhook.verify(PAYLOAD, {
      "svix-id": MSG_ID,
      "svix-signature": signature,
      "svix-timestamp": timestamp,
    });

    assert.deepEqual(event, { test: "data" });
  });

  it("normalizes header name casing", () => {
    const { webhook, signature, timestamp } = sign();

    const event = webhook.verify(PAYLOAD, {
      "Webhook-Id": MSG_ID,
      "Webhook-Signature": signature,
      "Webhook-Timestamp": timestamp,
    });

    assert.deepEqual(event, { test: "data" });
  });

  it("rejects meteroid-* headers", () => {
    const { webhook, signature, timestamp } = sign();

    assert.throws(
      () =>
        webhook.verify(PAYLOAD, {
          "meteroid-id": MSG_ID,
          "meteroid-signature": signature,
          "meteroid-timestamp": timestamp,
        }),
      (err: unknown) =>
        err instanceof WebhookVerificationError &&
        /Missing required headers/.test((err as Error).message)
    );
  });

  it("lets a webhook-* header shadow a valid svix-* one", () => {
    const { webhook, signature, timestamp } = sign();

    // `webhook-*` wins, so the garbage signature is the one that gets checked.
    assert.throws(
      () =>
        webhook.verify(PAYLOAD, {
          "webhook-id": MSG_ID,
          "webhook-signature": "v1,not-a-real-signature",
          "webhook-timestamp": timestamp,
          "svix-id": MSG_ID,
          "svix-signature": signature,
          "svix-timestamp": timestamp,
        }),
      WebhookVerificationError
    );
  });

  it("uses the webhook-* headers when the svix-* ones are garbage", () => {
    const { webhook, signature, timestamp } = sign();

    const event = webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
      "svix-id": "msg_other",
      "svix-signature": "v1,not-a-real-signature",
      "svix-timestamp": timestamp,
    });

    assert.deepEqual(event, { test: "data" });
  });

  it("rejects an invalid signature", () => {
    const { webhook, timestamp } = sign();

    assert.throws(
      () =>
        webhook.verify(PAYLOAD, {
          "webhook-id": MSG_ID,
          "webhook-signature": "v1,invalid_signature_here",
          "webhook-timestamp": timestamp,
        }),
      WebhookVerificationError
    );
  });

  it("rejects a stale timestamp", () => {
    const webhook = new Webhook(SECRET);
    const old = new Date(Date.now() - 10 * 60 * 1000);

    assert.throws(
      () =>
        webhook.verify(PAYLOAD, {
          "svix-id": MSG_ID,
          "svix-signature": webhook.sign(MSG_ID, old, PAYLOAD),
          "svix-timestamp": Math.floor(old.getTime() / 1000).toString(),
        }),
      WebhookVerificationError
    );
  });
});
