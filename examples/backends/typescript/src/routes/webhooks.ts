/** `POST /api/webhooks/meteroid` — the signed webhook receiver. */

import { Webhook, WebhookVerificationError } from "@meteroid/sdk";

import type { WebhookAck } from "../dto.js";
import { ApiError } from "../error.js";
import { accepted, rawBody, type Reply, type ScribeRequest } from "../http.js";
import { log } from "../log.js";
import type { AppState } from "../state.js";

/**
 * Verify the Standard Webhooks signature over the **raw** request body, then act on
 * what the demo recognizes and acknowledge the rest.
 *
 * Two rules matter more than anything else here:
 *
 * 1. **Verify the raw bytes.** `rawBody(request)` is the exact payload Meteroid signed.
 *    Parsing the JSON and re-serializing it before verifying is the classic bug — any
 *    difference in key order or spacing breaks the signature. It is also why this
 *    backend has no body-parsing middleware for one to forget to turn off.
 * 2. **Never reject a correctly signed body for its shape.** Meteroid owns the event
 *    envelope and adds event types over time; a receiver that 400s on an unknown type
 *    breaks the first time the sender ships a new one. `400` is for a bad signature and
 *    for a body that is not JSON at all — nothing else.
 */
export async function receiveWebhook(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<WebhookAck>> {
  const secret = state.config.meteroidWebhookSecret;
  if (secret === "") {
    // An operator problem, not a caller problem: never report it as a bad signature.
    throw ApiError.internal(
      "METEROID_WEBHOOK_SECRET is not set, so inbound webhooks cannot be verified. " +
        "Copy the signing secret from your Meteroid webhook endpoint (examples/CATALOG.md).",
    );
  }

  // The SDK accepts both `webhook-*` and `svix-*` headers, enforces the five-minute
  // timestamp tolerance itself, and hands back the parsed JSON of what it verified.
  let event: unknown;
  try {
    event = new Webhook(secret).verify(rawBody(request), request.headers);
  } catch (err) {
    throw invalidSignature(err);
  }
  // `verify` answers `undefined`, rather than throwing, for a signed *empty* body.
  if (event === undefined) {
    throw new ApiError("WEBHOOK_SIGNATURE_INVALID", "Webhook body is signed but is not JSON: it is empty.");
  }

  const field = (name: string): string | null => {
    const value = typeof event === "object" && event !== null ? Reflect.get(event, name) : null;
    return typeof value === "string" ? value : null;
  };

  const eventType = field("type");
  // `webhook-id` is required and verification just passed, so there is always something
  // to echo.
  const eventId =
    field("id") ?? request.headers["webhook-id"] ?? request.headers["svix-id"] ?? "";

  // The demo "handles" invoice and subscription events by logging them; the frontend
  // shows the last few in its activity feed. Everything else is acknowledged, ignored,
  // and explicitly reported as unhandled.
  const handled =
    eventType !== null && (eventType.startsWith("invoice.") || eventType.startsWith("subscription."));
  if (handled) {
    log.info(`meteroid webhook handled event_id=${eventId} event_type=${eventType}`);
  }

  // 202: the signature verified and the body was accepted. Whether the demo understood
  // the event is what `handled` reports.
  return accepted({ received: true, event_id: eventId, type: eventType, handled });
}

/**
 * `verify` throws `WebhookVerificationError` for everything about the signature, and a
 * bare `SyntaxError` when the signature is fine but the body is not JSON. Both are the
 * contract's `400 WEBHOOK_SIGNATURE_INVALID`; an oversized body is already an `ApiError`.
 */
function invalidSignature(err: unknown): ApiError {
  if (err instanceof ApiError) {
    return err;
  }
  const reason = err instanceof Error ? err.message : String(err);
  return new ApiError(
    "WEBHOOK_SIGNATURE_INVALID",
    err instanceof WebhookVerificationError || !(err instanceof SyntaxError)
      ? `Webhook signature verification failed: ${reason}`
      : `Webhook body is signed but is not JSON: ${reason}`,
  );
}
