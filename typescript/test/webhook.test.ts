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

    webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
    });
  });

  it("accepts Svix (svix-*) headers", () => {
    const { webhook, signature, timestamp } = sign();

    webhook.verify(PAYLOAD, {
      "svix-id": MSG_ID,
      "svix-signature": signature,
      "svix-timestamp": timestamp,
    });
  });

  it("normalizes header name casing", () => {
    const { webhook, signature, timestamp } = sign();

    webhook.verify(PAYLOAD, {
      "Webhook-Id": MSG_ID,
      "Webhook-Signature": signature,
      "Webhook-Timestamp": timestamp,
    });
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

    webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
      "svix-id": "msg_other",
      "svix-signature": "v1,not-a-real-signature",
      "svix-timestamp": timestamp,
    });
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

  it("accepts string-array and undefined header values", () => {
    const { webhook, signature, timestamp } = sign();

    webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      // A header sent twice reaches Node as an array; the values are joined
      // with a space, like several signatures in a single header.
      "webhook-signature": ["v1,not-a-real-signature", signature],
      "webhook-timestamp": timestamp,
      "x-absent": undefined,
    });
  });

  it("falls back to svix-* when the webhook-* value is undefined", () => {
    const { webhook, signature, timestamp } = sign();

    webhook.verify(PAYLOAD, {
      "webhook-id": undefined,
      "webhook-signature": undefined,
      "webhook-timestamp": undefined,
      "svix-id": MSG_ID,
      "svix-signature": [signature],
      "svix-timestamp": timestamp,
    });
  });

  it("accepts a fetch Headers instance", () => {
    const { webhook, signature, timestamp } = sign();

    const headers = new Headers();
    headers.set("Webhook-Id", MSG_ID);
    headers.set("Webhook-Signature", signature);
    headers.set("Webhook-Timestamp", timestamp);

    assert.doesNotThrow(() => webhook.verify(PAYLOAD, headers));
  });

  it("applies the svix-* fallback to a fetch Headers instance", () => {
    const { webhook, signature, timestamp } = sign();

    const headers = new Headers({
      "svix-id": MSG_ID,
      "svix-signature": signature,
      "svix-timestamp": timestamp,
    });

    assert.doesNotThrow(() => webhook.verify(PAYLOAD, headers));
  });

  it("rejects a fetch Headers instance with a bad signature", () => {
    const { webhook, timestamp } = sign();

    const headers = new Headers({
      "webhook-id": MSG_ID,
      "webhook-signature": "v1,invalid_signature_here",
      "webhook-timestamp": timestamp,
    });

    assert.throws(() => webhook.verify(PAYLOAD, headers), WebhookVerificationError);
  });

  it("verifies a correctly signed non-JSON body", () => {
    const webhook = new Webhook(SECRET);
    const now = new Date();
    const payload = "not json";

    assert.doesNotThrow(() =>
      webhook.verify(payload, {
        "webhook-id": MSG_ID,
        "webhook-signature": webhook.sign(MSG_ID, now, payload),
        "webhook-timestamp": Math.floor(now.getTime() / 1000).toString(),
      })
    );
  });

  it("verifies a correctly signed empty body", () => {
    const webhook = new Webhook(SECRET);
    const now = new Date();

    assert.doesNotThrow(() =>
      webhook.verify(Buffer.from(""), {
        "webhook-id": MSG_ID,
        "webhook-signature": webhook.sign(MSG_ID, now, ""),
        "webhook-timestamp": Math.floor(now.getTime() / 1000).toString(),
      })
    );
  });

  it("returns nothing", () => {
    const { webhook, signature, timestamp } = sign();

    const result = webhook.verify(PAYLOAD, {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
    });

    assert.equal(result, undefined);
  });

  it("verifies a correctly signed Buffer body", () => {
    const { webhook, signature, timestamp } = sign();

    webhook.verify(Buffer.from(PAYLOAD), {
      "webhook-id": MSG_ID,
      "webhook-signature": signature,
      "webhook-timestamp": timestamp,
    });
  });
});
