/**
 * `POST /api/webhooks/meteroid` — the signed receiver.
 *
 * Both SDKs ship a webhook *signer* as well as a verifier, so this endpoint can be driven
 * with no live tenant and no public tunnel: the suite signs its own payloads with the
 * same `whsec_…` the backend verifies against.
 *
 * **The negative cases are the ones that matter.** A receiver that accepts everything
 * passes every happy-path test ever written and hands an attacker the ability to mark
 * invoices paid. So for each way a signature can be wrong — tampered body, wrong secret,
 * missing header, malformed header, stale timestamp, future timestamp, wrong version —
 * there is a test that it is rejected, with `400 WEBHOOK_SIGNATURE_INVALID` and not the
 * `401` the contract reserves for a bad session token.
 *
 * The other rule under test is the opposite of strictness: a *correctly signed* body is
 * never rejected for its shape. Meteroid owns the event envelope, publishes no schema for
 * it, and adds event types over time; a receiver that 400s on an unknown type breaks the
 * first time the sender ships one.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { WEBHOOK_SECRET } from '../src/env.js';
import { skipTest } from '../src/skip.js';
import { signedWebhookRequest, TOLERANCE_SECONDS } from '../src/webhook.js';
import type { WebhookAck } from '../src/types.js';

const secret = WEBHOOK_SECRET;

function nowSeconds(): number {
  return Math.floor(Date.now() / 1000);
}

function event(type: string | null, extra: Record<string, unknown> = {}): Record<string, unknown> {
  return {
    id: `evt_${Math.random().toString(36).slice(2, 12)}`,
    ...(type === null ? {} : { type }),
    timestamp: new Date().toISOString(),
    ...extra,
  };
}

describe('POST /api/webhooks/meteroid', () => {
  it('has a signing secret to test with', (context) => {
    if (!secret) {
      skipTest(
        context,
        'METEROID_WEBHOOK_SECRET is not set, so the webhook receiver cannot be exercised. Set it ' +
          "to the same whsec_… value the backend has — it is the endpoint's signing secret from " +
          'the Meteroid dashboard (examples/CATALOG.md section 6).',
      );
    }
    expect(secret.startsWith('whsec_') || secret.length > 0).toBe(true);
  });

  describe.skipIf(!secret)('a correctly signed event', () => {
    it('is accepted and acknowledged', async () => {
      const body = event('invoice.paid');
      const signed = signedWebhookRequest(secret, body);

      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );

      expect(ack.received).toBe(true);
      expect(ack.event_id).toBe(body.id);
      expect(ack.type).toBe('invoice.paid');
      expect(ack.handled, 'the demo handles invoice.* events').toBe(true);
    });

    it('is accepted with the svix-* compatibility headers', async () => {
      const signed = signedWebhookRequest(secret, event('subscription.created'), {
        headerStyle: 'svix',
      });
      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );
      expect(ack.handled, 'the demo handles subscription.* events').toBe(true);
    });

    it('acknowledges an event type it has no handler for, rather than erroring', async () => {
      const signed = signedWebhookRequest(secret, event('quote.accepted'));
      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );
      expect(ack.type).toBe('quote.accepted');
      expect(
        ack.handled,
        'unknown event types are acknowledged and ignored — never an error, or the receiver ' +
          'breaks the day Meteroid ships a new type',
      ).toBe(false);
    });

    it('accepts an envelope whose shape it did not expect', async () => {
      // No `type`, no `timestamp`, and fields the demo has never seen. Meteroid owns this
      // envelope and publishes no schema for it; the signature is the gate, not the shape.
      const signed = signedWebhookRequest(secret, {
        id: 'evt_shapeless',
        data: { nested: { deeply: true } },
        api_version: '2099-01-01',
      });
      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );
      expect(ack.type).toBeNull();
      expect(ack.handled).toBe(false);
      expect(ack.event_id).toBe('evt_shapeless');
    });

    it('falls back to the webhook-id header when the body carries no id', async () => {
      const signed = signedWebhookRequest(secret, { type: 'invoice.finalized' });
      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );
      // `webhook-id` is a required header, so there is always something to echo.
      expect(ack.event_id).toBe(signed.messageId);
    });

    it('verifies the raw bytes, not a re-serialization of them', async () => {
      // Same JSON, unusual spacing and key order. A receiver that parses the body and
      // re-serializes it before verifying computes a different digest and rejects this —
      // the single most common webhook bug there is.
      const payload = '{  "type" : "invoice.paid",\n  "id":"evt_spacing"  }';
      const signed = signedWebhookRequest(secret, payload);
      const ack = expectStatus<WebhookAck>(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        202,
      );
      expect(ack.event_id).toBe('evt_spacing');
    });
  });

  describe.skipIf(!secret)('an invalid signature', () => {
    it('rejects a body that was changed after signing', async () => {
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      const tampered = signed.payload.replace('invoice.paid', 'invoice.voided');
      expect(tampered).not.toBe(signed.payload);

      expectError(
        await api.receiveMeteroidWebhook(tampered, signed.headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a payload signed with a different secret', async () => {
      const forged = signedWebhookRequest(
        'whsec_AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=',
        event('invoice.paid'),
      );
      expectError(
        await api.receiveMeteroidWebhook(forged.payload, forged.headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a request with no signature header', async () => {
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      const { 'webhook-signature': _dropped, ...headers } = signed.headers;
      expectError(
        await api.receiveMeteroidWebhook(signed.payload, headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a request with no webhook-id header', async () => {
      // The id is part of the signed string, so a missing one is unverifiable rather than
      // merely untidy.
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      const { 'webhook-id': _dropped, ...headers } = signed.headers;
      expectError(
        await api.receiveMeteroidWebhook(signed.payload, headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a malformed signature header', async () => {
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      for (const signature of ['garbage', 'v1,', 'v1,not-base-64!!', '']) {
        expectError(
          await api.receiveMeteroidWebhook(signed.payload, {
            ...signed.headers,
            'webhook-signature': signature,
          }),
          400,
          'WEBHOOK_SIGNATURE_INVALID',
        );
      }
    });

    it('rejects a signature offered under a version it does not implement', async () => {
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      const v2 = signed.headers['webhook-signature'].replace('v1,', 'v2,');
      expectError(
        await api.receiveMeteroidWebhook(signed.payload, { ...signed.headers, 'webhook-signature': v2 }),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a replay from outside the timestamp tolerance', async () => {
      // Correctly signed — for an hour ago. Without the tolerance check a captured request
      // is replayable forever.
      const stale = signedWebhookRequest(secret, event('invoice.paid'), {
        timestamp: nowSeconds() - (TOLERANCE_SECONDS + 3600),
      });
      expectError(
        await api.receiveMeteroidWebhook(stale.payload, stale.headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a timestamp too far in the future', async () => {
      const ahead = signedWebhookRequest(secret, event('invoice.paid'), {
        timestamp: nowSeconds() + (TOLERANCE_SECONDS + 3600),
      });
      expectError(
        await api.receiveMeteroidWebhook(ahead.payload, ahead.headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects a timestamp that is not a number', async () => {
      const signed = signedWebhookRequest(secret, event('invoice.paid'));
      expectError(
        await api.receiveMeteroidWebhook(signed.payload, {
          ...signed.headers,
          'webhook-timestamp': 'yesterday',
        }),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });

    it('rejects an unsigned request outright', async () => {
      expectError(
        await api.receiveMeteroidWebhook(JSON.stringify(event('invoice.paid')), {
          'content-type': 'application/json',
        }),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });
  });

  describe.skipIf(!secret)('a signed body that is not an event', () => {
    it('rejects a correctly signed body that is not JSON', async () => {
      // The one shape-related 400 the contract allows: the signature is fine, but there is
      // no envelope to read.
      const signed = signedWebhookRequest(secret, 'this is not json');
      expectError(
        await api.receiveMeteroidWebhook(signed.payload, signed.headers),
        400,
        'WEBHOOK_SIGNATURE_INVALID',
      );
    });
  });
});
