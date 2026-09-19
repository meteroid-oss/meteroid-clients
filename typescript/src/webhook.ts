import { Webhook as StdWh, WebhookVerificationError } from "standardwebhooks";

// Re-export for users to catch specific verification errors
export { WebhookVerificationError };

export interface WebhookOptions {
  format?: "raw";
}

export interface WebhookRequiredHeaders {
  "webhook-id": string;
  "webhook-signature": string;
  "webhook-timestamp": string;
}

const HEADER_ID = "webhook-id";
const HEADER_SIGNATURE = "webhook-signature";
const HEADER_TIMESTAMP = "webhook-timestamp";

const SVIX_ID = "svix-id";
const SVIX_SIGNATURE = "svix-signature";
const SVIX_TIMESTAMP = "svix-timestamp";

/**
 * Webhook verification utility for verifying incoming webhook payloads.
 *
 * Uses the standardwebhooks library for HMAC-SHA256 signature verification.
 *
 * Two header naming conventions are accepted, matching the Rust, Java and Python
 * SDKs:
 *
 * - **Standard Webhooks** (preferred): `webhook-id`, `webhook-signature`,
 *   `webhook-timestamp`
 * - **Svix** (for compatibility): `svix-id`, `svix-signature`, `svix-timestamp`
 *
 * A `webhook-*` header always takes precedence over its `svix-*` counterpart when
 * both are present.
 */
export class Webhook {
  private readonly inner: StdWh;

  /**
   * Create a new Webhook verifier.
   *
   * @param secret The webhook signing secret (base64 encoded or prefixed with "whsec_")
   * @param options Optional configuration
   */
  constructor(secret: string | Uint8Array, options?: WebhookOptions) {
    this.inner = new StdWh(secret, options);
  }

  /**
   * Verify a webhook payload and return the parsed JSON body.
   *
   * @param payload The raw webhook payload (string or Buffer)
   * @param headers The webhook headers (must include `webhook-id`,
   *   `webhook-signature` and `webhook-timestamp`, or their `svix-*` aliases)
   * @returns The verified and parsed webhook payload
   * @throws WebhookVerificationError if verification fails
   */
  public verify(
    payload: string | Buffer,
    headers_: WebhookRequiredHeaders | Record<string, string>
  ): unknown {
    // Normalize headers to lowercase; header names are case-insensitive but a
    // plain object is not.
    const headers: Record<string, string> = {};
    for (const key of Object.keys(headers_)) {
      headers[key.toLowerCase()] = (headers_ as Record<string, string>)[key];
    }

    // Copy each `svix-*` header onto its `webhook-*` counterpart, but only when
    // the `webhook-*` one is absent: Standard Webhooks headers win.
    copyFallback(headers, HEADER_ID, SVIX_ID);
    copyFallback(headers, HEADER_SIGNATURE, SVIX_SIGNATURE);
    copyFallback(headers, HEADER_TIMESTAMP, SVIX_TIMESTAMP);

    return this.inner.verify(payload, headers);
  }

  /**
   * Sign a webhook payload.
   *
   * @param msgId Unique message identifier
   * @param timestamp Timestamp for the signature
   * @param payload The payload to sign (string or Buffer)
   * @returns The signature string
   */
  public sign(msgId: string, timestamp: Date, payload: string | Buffer): string {
    return this.inner.sign(msgId, timestamp, payload);
  }
}

function copyFallback(
  headers: Record<string, string>,
  primary: string,
  fallback: string
): void {
  if (headers[primary] === undefined && headers[fallback] !== undefined) {
    headers[primary] = headers[fallback];
  }
}
