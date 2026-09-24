import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { createMeteroid, type MeteroidOptions } from "../src/client";
import { EffectiveEntitlementListResponseSerializer } from "../src/models/effectiveEntitlementListResponse";
import { CUSTOMER, ENTITLEMENTS, flush, json, mockApi, SUBSCRIPTIONS } from "./helpers";

function setup(
  routes?: Parameters<typeof mockApi>[0],
  options: Partial<MeteroidOptions> = {}
) {
  const api = mockApi(routes);
  let tokenCalls = 0;
  const client = createMeteroid({
    getToken: async () => {
      tokenCalls += 1;
      return { token: `tok_${tokenCalls}`, api_url: "https://api.test" };
    },
    fetch: api.fetch,
    ...options,
  });
  return { client, calls: api.calls, tokenCalls: () => tokenCalls };
}

describe("data access", () => {
  it("parses the customer from its snake_case wire form", async () => {
    const { client } = setup();
    assert.deepEqual(await client.customer.get(), {
      id: "cus_1",
      alias: "acme",
      name: "Acme",
      currency: "EUR",
      billingEmail: "billing@acme.com",
    });
  });

  it("parses subscriptions", async () => {
    const { client } = setup();
    assert.deepEqual(await client.subscriptions.list(), {
      data: [
        {
          id: "sub_1",
          planId: "plan_1",
          planName: "Pro",
          planVersion: 3,
          status: "ACTIVE",
          currency: "EUR",
          billingPeriod: "MONTHLY",
          startDate: "2026-01-01",
          endDate: null,
          currentPeriodStart: "2026-09-01",
          currentPeriodEnd: "2026-10-01",
        },
      ],
    });
  });

  it("parses entitlements with the server schema", async () => {
    const { client } = setup();
    const { data } = await client.entitlements.list();
    assert.deepEqual(
      data,
      EffectiveEntitlementListResponseSerializer._fromJsonObject(ENTITLEMENTS).data
    );
    const metered = data[1].value;
    assert.equal(metered.type, "METERED");
    assert.ok(metered.type === "METERED" && metered.usage.resetAt instanceof Date);
  });

  it("skips entitlements of a kind it does not know", async () => {
    const { client } = setup({
      "/entitlements": {
        data: [
          { feature: { id: "f1", name: "New", code: "new" }, value: { type: "QUANTUM" } },
          ENTITLEMENTS.data[0],
        ],
      },
    });
    const { data } = await client.entitlements.list();
    assert.deepEqual(
      data.map((e) => e.feature.code),
      ["sso"]
    );
  });

  it("does nothing until used", async () => {
    const { calls, tokenCalls } = setup();
    await flush();
    assert.equal(calls.length, 0);
    assert.equal(tokenCalls(), 0);
  });
});

describe("store", () => {
  it("loads everything on the first subscribe, with one token fetch", async () => {
    const { client, calls, tokenCalls } = setup();
    const before = client.getSnapshot();
    assert.equal(before.entitlements.status, "loading");
    let notified = 0;
    const unsubscribe = client.subscribe(() => {
      notified += 1;
    });
    await flush();
    const after = client.getSnapshot();
    assert.equal(tokenCalls(), 1);
    assert.deepEqual(calls.map((c) => new URL(c.url).pathname).sort(), [
      "/api/client/v1/customer",
      "/api/client/v1/entitlements",
      "/api/client/v1/subscriptions",
    ]);
    assert.equal(notified, 3);
    assert.equal(after.entitlements.status, "ready");
    assert.equal(after.customer.data?.name, "Acme");
    assert.equal(after.subscriptions.data?.[0].planName, "Pro");
    assert.equal(client.check("sso").hasAccess, true);
    assert.equal(client.check("api_calls").usage?.consumed, "1234");
    unsubscribe();
  });

  it("keeps each resource's reference until it changes", async () => {
    const { client } = setup();
    client.subscribe(() => {});
    await flush();
    const first = client.getSnapshot();
    assert.equal(client.getSnapshot(), first);
    await client.refresh();
    const second = client.getSnapshot();
    assert.notEqual(second, first);
    assert.notEqual(second.customer, first.customer);
  });

  it("hydrates from initialEntitlements, also when dates went through JSON", () => {
    const initial =
      EffectiveEntitlementListResponseSerializer._fromJsonObject(ENTITLEMENTS);
    const { client } = setup(undefined, {
      initialEntitlements: JSON.parse(JSON.stringify(initial)),
    });
    const server = client.getServerSnapshot();
    assert.equal(server, client.getSnapshot());
    assert.equal(server.entitlements.status, "ready");
    assert.equal(server.customer.status, "loading");
    const usage = client.check("api_calls").usage;
    assert.deepEqual(usage?.resetAt, new Date("2026-10-01T00:00:00Z"));
    assert.equal(client.check("sso").hasAccess, true);
  });

  it("keeps the server snapshot stable after loading", async () => {
    const { client } = setup();
    const server = client.getServerSnapshot();
    client.subscribe(() => {});
    await flush();
    assert.equal(client.getServerSnapshot(), server);
    assert.equal(server.entitlements.status, "loading");
  });

  it("runs one more pass for refreshes asked during a refresh", async () => {
    const { client, calls } = setup();
    const first = client.refresh();
    const second = client.refresh();
    const third = client.refresh();
    assert.equal(second, third);
    await Promise.all([first, second, third]);
    assert.equal(calls.length, 6);
  });

  it("reports an error, and keeps loaded data when a later refresh fails", async () => {
    let fail = true;
    const { client } = setup({
      "/customer": () =>
        fail
          ? json(500, { code: "INTERNAL_SERVER_ERROR", message: "boom" })
          : json(200, CUSTOMER),
      "/entitlements": () =>
        fail
          ? json(500, { code: "INTERNAL_SERVER_ERROR", message: "boom" })
          : json(200, ENTITLEMENTS),
      "/subscriptions": SUBSCRIPTIONS,
    });
    await client.refresh();
    assert.equal(client.getSnapshot().entitlements.status, "error");
    assert.equal(client.check("sso").isFallback, true);

    fail = false;
    await client.refresh();
    assert.equal(client.getSnapshot().entitlements.status, "ready");

    fail = true;
    await client.refresh();
    const { entitlements } = client.getSnapshot();
    assert.equal(entitlements.status, "ready");
    assert.ok(entitlements.error);
    assert.equal(client.check("sso").hasAccess, true);
  });

  it("stops notifying once destroyed", async () => {
    const { client, calls } = setup();
    let notified = 0;
    client.subscribe(() => {
      notified += 1;
    });
    client.destroy();
    await flush();
    await client.refresh();
    assert.equal(notified, 0);
    assert.equal(client.getSnapshot().entitlements.status, "loading");
    assert.ok(calls.length <= 3);
  });
});
