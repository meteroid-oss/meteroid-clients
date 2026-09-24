import type { EffectiveEntitlementListResponse } from "@meteroid/browser";

export const PORTAL = "https://portal.example";

export const entitlementsFor = (limit: string | null = "10000") => ({
  data: [
    {
      feature: { id: "feat_sso", name: "SSO", code: "sso" },
      value: { type: "BOOLEAN", enabled: true },
    },
    {
      feature: { id: "feat_api", name: "API calls", code: "api_calls" },
      value: {
        type: "METERED",
        spec: {
          metric_id: "bm_1",
          limit,
          reset_period: { type: "BILLING_CYCLE" },
          enabled: true,
        },
        usage: { consumed: "1234", reset_at: "2026-10-01T00:00:00Z" },
      },
    },
  ],
});

/** `entitlementsFor()` as parsed by the SDKs, e.g. `@meteroid/sdk` on the server. */
export const parsedEntitlements = (): EffectiveEntitlementListResponse => ({
  data: [
    {
      feature: { id: "feat_sso", name: "SSO", code: "sso" },
      value: { type: "BOOLEAN", enabled: true },
    },
    {
      feature: { id: "feat_api", name: "API calls", code: "api_calls" },
      value: {
        type: "METERED",
        spec: {
          metricId: "bm_1",
          limit: "10000",
          resetPeriod: { type: "BILLING_CYCLE" },
          enabled: true,
        },
        usage: { consumed: "1234", resetAt: new Date("2026-10-01T00:00:00Z") },
      },
    },
  ],
});

export const customerFor = (name: string) => ({
  id: `cus_${name}`,
  name,
  currency: "EUR",
});

export const SUBSCRIPTIONS = {
  data: [
    {
      id: "sub_1",
      plan_id: "plan_1",
      plan_name: "Pro",
      plan_version: 3,
      status: "ACTIVE",
      currency: "EUR",
      start_date: "2026-01-01",
      current_period_start: "2026-09-01",
    },
  ],
};

export function json(status: number, body: unknown) {
  return new Response(JSON.stringify(body), {
    status,
    headers: { "content-type": "application/json" },
  });
}

export type Handler = (path: string, authorization: string) => Response | undefined;

/** Installs a global fetch answering the client API; `handler` can override routes. */
export function mockApi(handler: Handler = () => undefined) {
  const calls: { path: string; authorization: string }[] = [];
  globalThis.fetch = (async (input: string, init: RequestInit) => {
    const path = new URL(input).pathname.replace("/api/client/v1", "");
    const authorization = (init.headers as Record<string, string>).authorization;
    calls.push({ path, authorization });
    const custom = handler(path, authorization);
    if (custom) {
      return custom;
    }
    const who = authorization.replace("Bearer tok_", "");
    switch (path) {
      case "/entitlements":
        return json(200, entitlementsFor());
      case "/customer":
        return json(200, customerFor(who));
      default:
        return json(200, SUBSCRIPTIONS);
    }
  }) as unknown as typeof fetch;
  return calls;
}

export const flush = () => new Promise((resolve) => setImmediate(resolve));
