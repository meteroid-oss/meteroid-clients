import { ApiException } from "./errors";
import { ErrorCode } from "./models/errorCode";
import type { TokenSource } from "./token";

/** Where the client API is served when neither `apiUrl` nor the token says otherwise. */
export const DEFAULT_API_URL = "https://api.meteroid.com";

const MAX_RETRY_AFTER_MS = 60_000;

/** @internal */
export type Get = <T>(path: string, parse: (json: any) => T) => Promise<T>;

/** @internal */
export interface HttpOptions {
  apiUrl?: string;
  fetch?: typeof fetch;
  sleep?: (ms: number) => Promise<void>;
  now?: () => number;
}

function retryAfterMs(header: string | null, now: number): number {
  if (!header) {
    return 1000;
  }
  const ms = /^\s*\d+\s*$/.test(header)
    ? Number(header) * 1000
    : Date.parse(header) - now;
  return Number.isNaN(ms) ? 1000 : Math.min(MAX_RETRY_AFTER_MS, Math.max(0, ms));
}

/**
 * @internal GET `{apiUrl}/api/client/v1{path}`, with only the CORS-safe `authorization` header.
 * Retries once: with a new token after a 401 `TOKEN_EXPIRED`, or after a 429's `Retry-After`,
 * which also holds back the requests that follow.
 */
export function createHttp(tokens: TokenSource, options: HttpOptions = {}): Get {
  const sleep =
    options.sleep ?? ((ms: number) => new Promise<void>((r) => setTimeout(r, ms)));
  const now = options.now ?? Date.now;
  let notBefore = 0;

  return async (path, parse) => {
    let token = await tokens.get();
    for (let attempt = 0; ; attempt++) {
      const wait = notBefore - now();
      if (wait > 0) {
        await sleep(wait);
      }
      const base = (options.apiUrl ?? token.apiUrl ?? DEFAULT_API_URL).replace(
        /\/+$/,
        ""
      );
      const response = await (options.fetch ?? fetch)(`${base}/api/client/v1${path}`, {
        headers: { authorization: `Bearer ${token.token}` },
      });
      if (response.ok) {
        return parse(await response.json());
      }
      const error = new ApiException(response.status, await response.text());
      if (attempt > 0) {
        throw error;
      }
      if (response.status === 401 && error.restError?.code === ErrorCode.TokenExpired) {
        token = await tokens.refresh(token.token);
      } else if (response.status === 429) {
        const delay = retryAfterMs(response.headers.get("retry-after"), now());
        notBefore = Math.max(notBefore, now() + delay);
      } else {
        throw error;
      }
    }
  };
}
