/**
 * What `getToken` may resolve to: the token alone, or the response of
 * `POST /api/v1/customers/{id_or_alias}/portal-token` as-is, in `snake_case` (raw
 * REST) or `camelCase` (`@meteroid/sdk`). Other fields are ignored.
 */
export interface TokenResponse {
  token: string;
  expires_at?: string | null;
  expiresAt?: string | Date | null;
  api_url?: string | null;
  apiUrl?: string | null;
  portal_url?: string | null;
  portalUrl?: string | null;
}

/** Fetches a token for the signed-in customer from your backend. */
export type GetToken = () => Promise<string | TokenResponse>;

/** @internal */
export interface ClientToken {
  token: string;
  /** Epoch milliseconds, when known. */
  expiresAt?: number;
  apiUrl?: string;
  portalUrl?: string;
}

/** @internal */
export interface TokenSource {
  /** A token that is not about to expire, fetched when needed (single-flight). */
  get(): Promise<ClientToken>;
  /** A new token, unless the current one already differs from `stale`. */
  refresh(stale?: string): Promise<ClientToken>;
  /** While enabled, a new token is fetched ahead of the current one's expiry. */
  keepFresh(enabled: boolean): void;
}

const REFRESH_MARGIN_MS = 60_000;
// Longer delays overflow setTimeout's 32-bit delay and would fire immediately.
const MAX_TIMER_MS = 0x7fffffff;

const nonEmpty = (value: unknown): string | undefined =>
  typeof value === "string" && value !== "" ? value : undefined;

/** @internal The `exp` claim of a JWT, in epoch milliseconds. */
export function jwtExpiry(token: string): number | undefined {
  try {
    const payload = token.split(".")[1].replace(/-/g, "+").replace(/_/g, "/");
    const exp = JSON.parse(atob(payload)).exp;
    return typeof exp === "number" ? exp * 1000 : undefined;
  } catch {
    return undefined;
  }
}

/** @internal */
export function parseTokenResponse(value: unknown): ClientToken {
  const response = (typeof value === "string" ? { token: value } : value) as
    | Partial<TokenResponse>
    | null
    | undefined;
  const token = nonEmpty(response?.token);
  if (response == null || token === undefined) {
    throw new TypeError(
      "Meteroid: getToken() must resolve to a token string or a portal-token response"
    );
  }
  const expires = response.expires_at ?? response.expiresAt;
  const expiresAt = expires != null ? new Date(expires).getTime() : Number.NaN;
  return {
    token,
    expiresAt: Number.isFinite(expiresAt) ? expiresAt : jwtExpiry(token),
    apiUrl: nonEmpty(response.api_url ?? response.apiUrl),
    portalUrl: nonEmpty(response.portal_url ?? response.portalUrl),
  };
}

/** @internal */
export function createTokenSource(getToken: GetToken, now = Date.now): TokenSource {
  let current: ClientToken | undefined;
  let staleAt = Number.POSITIVE_INFINITY;
  let inflight: Promise<ClientToken> | undefined;
  let timer: ReturnType<typeof setTimeout> | undefined;
  let fresh = false;

  const schedule = () => {
    clearTimeout(timer);
    timer = undefined;
    const delay = staleAt - now();
    if (fresh && delay < MAX_TIMER_MS) {
      timer = setTimeout(() => load().catch(() => {}), Math.max(0, delay));
    }
  };

  const load = (): Promise<ClientToken> => {
    inflight ??= Promise.resolve()
      .then(getToken)
      .then((value) => {
        const token = parseTokenResponse(value);
        const receivedAt = now();
        // Already expired by our clock (skew, or a cached token): rely on the 401 retry.
        if (token.expiresAt !== undefined && token.expiresAt <= receivedAt) {
          token.expiresAt = undefined;
        }
        current = token;
        staleAt =
          token.expiresAt === undefined
            ? Number.POSITIVE_INFINITY
            : token.expiresAt -
              Math.min(REFRESH_MARGIN_MS, (token.expiresAt - receivedAt) / 2);
        schedule();
        return token;
      })
      .finally(() => {
        inflight = undefined;
      });
    return inflight;
  };

  return {
    async get() {
      if (current !== undefined && now() < staleAt) {
        return current;
      }
      try {
        return await load();
      } catch (error) {
        if (current?.expiresAt !== undefined && now() < current.expiresAt) {
          return current;
        }
        throw error;
      }
    },
    refresh(stale) {
      return current !== undefined && stale !== undefined && current.token !== stale
        ? Promise.resolve(current)
        : load();
    },
    keepFresh(enabled) {
      fresh = enabled;
      schedule();
    },
  };
}
