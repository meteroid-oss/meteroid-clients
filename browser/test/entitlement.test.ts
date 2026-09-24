import assert from "node:assert/strict";
import { describe, it } from "node:test";
import type { ResourceState } from "../src/client";
import { checkEntitlement } from "../src/entitlement";
import {
  type EffectiveEntitlement,
  EffectiveEntitlementSerializer,
} from "../src/models/effectiveEntitlement";

const ready = (...items: object[]): ResourceState<EffectiveEntitlement[]> => ({
  status: "ready",
  data: items.map((item) => EffectiveEntitlementSerializer._fromJsonObject(item)),
  error: undefined,
});

const boolean = (enabled: boolean) => ({
  feature: { id: "feat_1", name: "SSO", code: "sso" },
  value: { type: "BOOLEAN", enabled },
});

const metered = (
  limit: string | undefined,
  usage: { consumed?: string; remaining?: string },
  enabled = true
) => ({
  feature: { id: "feat_2", name: "API calls", code: "api_calls" },
  value: {
    type: "METERED",
    spec: { metric_id: "bm_1", limit, reset_period: { type: "NEVER" }, enabled },
    usage,
  },
});

const access = (item: object, code = "api_calls") =>
  checkEntitlement(ready(item), code).hasAccess;

describe("checkEntitlement", () => {
  it("grants a Boolean feature when enabled", () => {
    assert.equal(access(boolean(true), "sso"), true);
    assert.equal(access(boolean(false), "sso"), false);
  });

  it("grants a Config feature when present and exposes its value", () => {
    const check = checkEntitlement(
      ready({
        feature: { id: "feat_3", name: "Seats", code: "seats" },
        value: { type: "CONFIG", value: { kind: "NUMBER", value: "5" } },
      }),
      "seats"
    );
    assert.equal(check.hasAccess, true);
    assert.deepEqual(check.value, { kind: "NUMBER", value: "5" });
    assert.equal(check.usage, undefined);
  });

  it("denies a feature the customer has no entitlement for", () => {
    const check = checkEntitlement(ready(boolean(true)), "unknown");
    assert.deepEqual(check, {
      status: "ready",
      hasAccess: false,
      isFallback: false,
      entitlement: undefined,
    });
  });

  describe("metered", () => {
    it("grants an unlimited feature (no limit), whatever the usage", () => {
      assert.equal(
        access(metered(undefined, { consumed: "1000000", remaining: "0" })),
        true
      );
      assert.equal(access(metered(undefined, {})), true);
    });

    it("decides on remaining when it is present", () => {
      assert.equal(access(metered("10", { consumed: "1", remaining: "9" })), true);
      assert.equal(access(metered("1", { consumed: "0.5", remaining: "0.5" })), true);
      assert.equal(access(metered("10", { consumed: "10", remaining: "0" })), false);
      assert.equal(access(metered("10", { consumed: "11", remaining: "-1" })), false);
      assert.equal(access(metered("10", { remaining: "0.000" })), false);
    });

    it("compares consumed with the limit when remaining is absent", () => {
      assert.equal(access(metered("10000", { consumed: "9999.99" })), true);
      assert.equal(access(metered("10000", { consumed: "10000.00" })), false);
      assert.equal(access(metered("0.5", { consumed: "0.25" })), true);
    });

    it("grants a limited feature without usage figures and flags it", () => {
      const check = checkEntitlement(ready(metered("100", {})), "api_calls");
      assert.equal(check.hasAccess, true);
      assert.equal(check.usage?.unknown, true);
    });

    it("never grants a disabled feature", () => {
      assert.equal(access(metered(undefined, {}, false)), false);
      assert.equal(access(metered("10", { remaining: "5" }, false)), false);
    });

    it("denies when a figure is not a plain decimal", () => {
      assert.equal(access(metered("10", { remaining: "lots" })), false);
    });

    it("returns the usage with absent figures as undefined", () => {
      const check = checkEntitlement(
        ready({
          feature: { id: "feat_2", name: "API calls", code: "api_calls" },
          value: {
            type: "METERED",
            spec: {
              metric_id: "bm_1",
              limit: "10000",
              reset_period: { type: "BILLING_CYCLE" },
              enabled: true,
            },
            usage: {
              consumed: "1234",
              remaining: null,
              reset_at: "2026-10-01T00:00:00Z",
            },
          },
        }),
        "api_calls"
      );
      assert.deepEqual(check.usage, {
        consumed: "1234",
        limit: "10000",
        remaining: undefined,
        resetAt: new Date("2026-10-01T00:00:00Z"),
        unknown: false,
      });
      assert.equal(check.hasAccess, true);
    });
  });

  describe("before the entitlements are known", () => {
    const loading: ResourceState<EffectiveEntitlement[]> = {
      status: "loading",
      data: undefined,
      error: undefined,
    };

    it("answers with the fallback, flagged as such", () => {
      assert.deepEqual(checkEntitlement(loading, "sso"), {
        status: "loading",
        hasAccess: false,
        isFallback: true,
        entitlement: undefined,
      });
      assert.equal(checkEntitlement(loading, "sso", { fallback: true }).hasAccess, true);
    });

    it("keeps the error status when loading failed", () => {
      const failed = { status: "error" as const, data: undefined, error: new Error("x") };
      const check = checkEntitlement(failed, "sso", { fallback: true });
      assert.equal(check.status, "error");
      assert.equal(check.hasAccess, true);
      assert.equal(check.isFallback, true);
    });
  });
});
