/**
 * Configuration, entirely from the environment. Nothing here is ever hard-coded —
 * see `examples/.env.example` for the full list and `README.md` for how to set it.
 */

import { Currency, Meteroid } from "@meteroid/sdk";

/** Everything the backend needs to start. Read once, at boot. */
export interface Config {
  /**
   * Meteroid API key. May be empty: the process still starts so that `GET /api/health`
   * can report `meteroid_configured: false` instead of the operator getting a silent crash.
   */
  meteroidApiKey: string;
  meteroidBaseUrl: string;
  /** Signing secret of the Meteroid webhook endpoint (`whsec_…`). May be empty. */
  meteroidWebhookSecret: string;
  /** HMAC key for demo session tokens. Not a Meteroid credential. */
  sessionSecret: string;
  /** Currency new demo customers are created with. Must match the seeded plans. */
  defaultCurrency: Currency;
  port: number;
}

/** A configuration problem the operator has to fix. Reported at startup, never to a client. */
export class ConfigError extends Error {
  public constructor(message: string) {
    super(message);
    this.name = "ConfigError";
  }
}

export function configFromEnv(env: NodeJS.ProcessEnv = process.env): Config {
  const nonEmpty = (key: string): string | undefined => env[key]?.trim() || undefined;

  // `PORT` is the convention every host uses; `SCRIBE_PORT` is what
  // examples/.env.example calls it. Accept both, `PORT` wins.
  const rawPort = nonEmpty("PORT") ?? nonEmpty("SCRIBE_PORT") ?? "8082";
  const port = /^\d+$/.test(rawPort) ? Number(rawPort) : Number.NaN;
  if (!(port >= 1 && port <= 65535)) {
    throw new ConfigError(
      `PORT must be a number between 1 and 65535, got ${JSON.stringify(rawPort)}`,
    );
  }

  // The session secret has no safe default: a predictable one would let anyone mint a
  // token for any workspace. Refuse to start without it.
  const sessionSecret = nonEmpty("SCRIBE_SESSION_SECRET");
  if (sessionSecret === undefined) {
    throw new ConfigError(
      "SCRIBE_SESSION_SECRET is not set. It is the HMAC key for demo session tokens; " +
        "generate one with `openssl rand -hex 32`. See examples/.env.example.",
    );
  }

  return {
    meteroidApiKey: nonEmpty("METEROID_API_KEY") ?? "",
    meteroidBaseUrl: nonEmpty("METEROID_BASE_URL") ?? "https://api.meteroid.com",
    meteroidWebhookSecret: nonEmpty("METEROID_WEBHOOK_SECRET") ?? "",
    sessionSecret,
    defaultCurrency: parseCurrency(nonEmpty("SCRIBE_DEFAULT_CURRENCY") ?? "USD"),
    port,
  };
}

/** True when the backend has enough credentials to reach Meteroid at all. */
export function meteroidConfigured(config: Config): boolean {
  return config.meteroidApiKey !== "" && config.meteroidBaseUrl !== "";
}

/**
 * Build the Meteroid SDK client. One client is shared by every handler; it is
 * immutable, so sharing it needs no care at all.
 */
export function meteroidClient(config: Config): Meteroid {
  return new Meteroid(config.meteroidApiKey, {
    serverUrl: config.meteroidBaseUrl,
    requestTimeout: 15_000,
  });
}

/**
 * `Currency` is a closed string enum in the SDK, so a configuration string gets in by
 * being checked against its values.
 */
function parseCurrency(code: string): Currency {
  const currency = Object.values(Currency).find((value) => value === code.toUpperCase());
  if (currency === undefined) {
    throw new ConfigError(
      `SCRIBE_DEFAULT_CURRENCY=${JSON.stringify(code)} is not an ISO 4217 code Meteroid recognizes.`,
    );
  }
  return currency;
}
