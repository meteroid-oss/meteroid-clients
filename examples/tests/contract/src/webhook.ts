/**
 * Standard Webhooks signing, so the suite can drive the webhook receiver like any other
 * endpoint — no live tenant, no public tunnel, no waiting for Meteroid to send something.
 *
 * The construction is the one both SDKs implement (`Webhook::sign` in Rust,
 * `Webhook.sign` in Java):
 *
 *   key       = base64_decode(secret without its `whsec_` prefix)
 *   signed    = HMAC_SHA256(key, `${webhook-id}.${webhook-timestamp}.${raw body}`)
 *   header    = `v1,${base64(signed)}`
 *
 * `webhook-timestamp` is Unix **seconds** and must be within five minutes of now.
 * The signature covers the raw body bytes, so this module signs the exact string that
 * goes on the wire and never a re-serialization of it.
 *
 * Verified offline against the published test vector — see `tests/00-harness.test.ts`.
 */

import { createHmac, randomUUID } from 'node:crypto';

export const SIGNATURE_VERSION = 'v1';

/** Five minutes, matching both SDK verifiers. */
export const TOLERANCE_SECONDS = 300;

function keyFromSecret(secret: string): Buffer {
  const material = secret.startsWith('whsec_') ? secret.slice('whsec_'.length) : secret;
  return Buffer.from(material, 'base64');
}

/** `v1,<base64>` for one message. */
export function signWebhook(
  secret: string,
  messageId: string,
  timestampSeconds: number,
  payload: string,
): string {
  const signed = createHmac('sha256', keyFromSecret(secret))
    .update(`${messageId}.${timestampSeconds}.${payload}`)
    .digest('base64');
  return `${SIGNATURE_VERSION},${signed}`;
}

export interface SignedRequest {
  /** The exact bytes that were signed. Send these verbatim. */
  payload: string;
  headers: Record<string, string>;
  messageId: string;
  timestamp: number;
}

export interface SignOptions {
  /** Defaults to a fresh UUID. */
  messageId?: string;
  /** Unix seconds. Defaults to now. */
  timestamp?: number;
  /** `webhook-*` (Standard Webhooks) or `svix-*` (the compatibility aliases). */
  headerStyle?: 'webhook' | 'svix';
  /** Sign with this secret but leave the body as `payload` — used to forge a bad signature. */
  signPayload?: string;
}

/**
 * Sign an event body and return it with the headers that carry the signature.
 *
 * `body` is serialized once, here, and the resulting string is both signed and sent.
 */
export function signedWebhookRequest(
  secret: string,
  body: unknown,
  options: SignOptions = {},
): SignedRequest {
  const payload = typeof body === 'string' ? body : JSON.stringify(body);
  const messageId = options.messageId ?? `msg_${randomUUID()}`;
  const timestamp = options.timestamp ?? Math.floor(Date.now() / 1000);
  const signature = signWebhook(secret, messageId, timestamp, options.signPayload ?? payload);

  const prefix = options.headerStyle === 'svix' ? 'svix' : 'webhook';
  return {
    payload,
    messageId,
    timestamp,
    headers: {
      [`${prefix}-id`]: messageId,
      [`${prefix}-timestamp`]: String(timestamp),
      [`${prefix}-signature`]: signature,
      'content-type': 'application/json',
    },
  };
}
