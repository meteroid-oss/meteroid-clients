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

/**
 * The request headers accepted by {@link Webhook.verify}:
 *
 * - a plain object whose values are strings, string arrays or `undefined`,
 *   such as Node's `IncomingHttpHeaders` (`req.headers` in Node, Express,
 *   Fastify, ...);
 * - a fetch `Headers` instance (`request.headers` in Next.js route handlers,
 *   Cloudflare Workers, Deno, Bun, ...).
 */
export type WebhookHeaders =
  | WebhookRequiredHeaders
  | Record<string, string | readonly string[] | undefined>
  | Headers;

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
   * @param payload The raw webhook payload (string or Buffer), exactly as
   *   received: parsing and re-serializing it breaks the signature
   * @param headers The request headers (must include `webhook-id`,
   *   `webhook-signature` and `webhook-timestamp`, or their `svix-*` aliases),
   *   as a plain object such as Node's `IncomingHttpHeaders` or as a fetch
   *   `Headers` instance. Header names are matched case-insensitively.
   * @returns The verified and parsed webhook payload
   * @throws WebhookVerificationError if verification fails
   */
  public verify(payload: string | Buffer, headers_: WebhookHeaders): unknown {
    const headers = normalizeHeaders(headers_);

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

/**
 * Copy `headers` into a plain object keyed by lower-case name.
 *
 * A header sent several times reaches Node as a string array; its values are
 * joined with a space, the separator `webhook-signature` uses between
 * signatures (a comma would corrupt the `v1,<signature>` pairs). Absent
 * (`undefined`) values are dropped.
 */
function normalizeHeaders(headers: WebhookHeaders): Record<string, string> {
  const out: Record<string, string> = {};
  if (isFetchHeaders(headers)) {
    headers.forEach((value, key) => {
      out[key.toLowerCase()] = value;
    });
    return out;
  }
  const record = headers as Record<string, string | readonly string[] | undefined>;
  for (const key of Object.keys(record)) {
    const value = record[key];
    if (value === undefined) {
      continue;
    }
    out[key.toLowerCase()] = typeof value === "string" ? value : value.join(" ");
  }
  return out;
}

// Duck-typed rather than `instanceof Headers`, so that `Headers` from another
// realm or fetch implementation (undici, node-fetch, ...) is recognised too. A
// plain header object never has function-valued `get` and `forEach` members.
function isFetchHeaders(headers: WebhookHeaders): headers is Headers {
  const h = headers as { get?: unknown; forEach?: unknown };
  return typeof h.get === "function" && typeof h.forEach === "function";
}
