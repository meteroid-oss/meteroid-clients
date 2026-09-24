import { JSDOM } from "jsdom";

export const ENTITLEMENTS = {
  data: [
    {
      feature: { id: "feat_sso", name: "SSO", code: "sso" },
      value: { type: "BOOLEAN", enabled: true },
    },
    {
      feature: {
        id: "feat_api",
        name: "API calls",
        code: "api_calls",
        product: { id: "prod_1", name: "Platform" },
      },
      value: {
        type: "METERED",
        spec: {
          metric_id: "bm_1",
          limit: "10000",
          reset_period: { type: "BILLING_CYCLE" },
          enabled: true,
        },
        usage: { consumed: "1234", remaining: "8766", reset_at: "2026-10-01T00:00:00Z" },
      },
    },
    {
      feature: { id: "feat_seats", name: "Seats", code: "seats" },
      value: { type: "CONFIG", value: { kind: "NUMBER", value: "5" } },
    },
  ],
};

export const CUSTOMER = {
  id: "cus_1",
  alias: "acme",
  name: "Acme",
  currency: "EUR",
  billing_email: "billing@acme.com",
};

export const SUBSCRIPTIONS = {
  data: [
    {
      id: "sub_1",
      plan_id: "plan_1",
      plan_name: "Pro",
      plan_version: 3,
      status: "ACTIVE",
      currency: "EUR",
      billing_period: "MONTHLY",
      start_date: "2026-01-01",
      end_date: null,
      current_period_start: "2026-09-01",
      current_period_end: "2026-10-01",
    },
  ],
};

export function json(
  status: number,
  body: unknown,
  headers: Record<string, string> = {}
) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json", ...headers },
  });
}

export type Call = { url: string; headers: Record<string, string> };

/** A fetch answering the client API from `routes` (path → body or Response factory). */
export function mockApi(
  routes: Record<string, unknown | (() => Response)> = {
    "/customer": CUSTOMER,
    "/entitlements": ENTITLEMENTS,
    "/subscriptions": SUBSCRIPTIONS,
  }
): { fetch: typeof fetch; calls: Call[] } {
  const calls: Call[] = [];
  const fetchImpl = (async (input: string | URL | Request, init?: RequestInit) => {
    const url = String(input);
    calls.push({ url, headers: (init?.headers ?? {}) as Record<string, string> });
    const path = new URL(url).pathname.replace("/api/client/v1", "");
    const route = routes[path];
    if (route === undefined) {
      return json(404, { code: "NOT_FOUND", message: "no route" });
    }
    return typeof route === "function" ? (route as () => Response)() : json(200, route);
  }) as typeof fetch;
  return { fetch: fetchImpl, calls };
}

const base64url = (value: object) =>
  Buffer.from(JSON.stringify(value)).toString("base64url");

/** An unsigned JWT carrying `payload`; the SDK only reads it. */
export const jwt = (payload: object) =>
  `${base64url({ alg: "HS256", typ: "JWT" })}.${base64url(payload)}.signature`;

/** Let pending promise callbacks and I/O run. */
export const flush = () => new Promise((resolve) => setImmediate(resolve));

/** Expose a jsdom window as the `window`/`document` globals the SDK uses. */
export function installDom(url = "https://merchant.example/billing"): JSDOM {
  const dom = new JSDOM("<!doctype html><html><body></body></html>", {
    url,
    pretendToBeVisual: true,
  });
  Object.assign(globalThis, { window: dom.window, document: dom.window.document });
  return dom;
}
