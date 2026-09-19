/** The pure pieces: session tokens, decimals, quota arithmetic, labels, wire shapes. */

import assert from "node:assert/strict";
import { createHmac } from "node:crypto";
import { test } from "node:test";

import type { MeteredEffectiveEntitlementValue, Subscription } from "@meteroid/sdk";
import { BillingPeriodEnum, Currency, SubscriptionStatusEnum } from "@meteroid/sdk";

import { featureLabel } from "../src/catalog.js";
import { configFromEnv, ConfigError } from "../src/config.js";
import { add, billableMinutes, greaterThan, normalize, subtract } from "../src/decimal.js";
import type { QuotaSnapshot } from "../src/dto.js";
import { quotaSnapshot } from "../src/entitlements.js";
import { ApiError } from "../src/error.js";
import { projectSubscription } from "../src/routes/session.js";
import { projectQuota } from "../src/routes/transcriptions.js";
import { mint, verify } from "../src/session.js";

// ---------------------------------------------------------------- session tokens

test("a session token round-trips an alias", () => {
  const token = mint("s3cret", "scribe-demo-8f2a1c");
  assert.equal(verify("s3cret", token), "scribe-demo-8f2a1c");
});

test("a session token is the construction the contract documents", () => {
  // Spelled out independently of `session.ts`, the way tests/contract/src/session.ts
  // does it, and pinned to a literal so a change to either side is caught: tokens
  // minted by one backend must verify on another.
  const alias = "scribe-demo-8f2a1c";
  const signature = createHmac("sha256", "s3cret").update(alias).digest("base64url");
  const expected = `v1.${Buffer.from(alias).toString("base64url")}.${signature}`;

  assert.equal(mint("s3cret", alias), expected);
  assert.equal(expected, "v1.c2NyaWJlLWRlbW8tOGYyYTFj.r50D_RuGiV8vaYqwra8Kvs1fDBE7cJ3EV1jYTRWQXiY");
});

test("another deployment's secret is rejected", () => {
  const token = mint("s3cret", "scribe-demo-8f2a1c");
  assert.throws(() => verify("other", token), ApiError);
});

test("a tampered payload is rejected", () => {
  const token = mint("s3cret", "scribe-demo-8f2a1c");
  const forged = `v1.${Buffer.from("someone-else").toString("base64url")}.${token.split(".")[2]}`;
  assert.throws(() => verify("s3cret", forged), ApiError);
});

test("a structurally invalid token is rejected, never partially decoded", () => {
  const token = mint("s3cret", "alias");
  for (const bad of ["", "garbage", "v1.only", "v2.YQ.YQ", `${token}.extra`, `${token}=`, "v1.!!!.abc", "v1.YQ.*"]) {
    assert.throws(() => verify("s3cret", bad), ApiError, bad);
  }
});

// ---------------------------------------------------------------- configuration

test("the session secret has no default", () => {
  assert.throws(() => configFromEnv({}), ConfigError);
  assert.throws(() => configFromEnv({ SCRIBE_SESSION_SECRET: "   " }), ConfigError);
});

test("PORT wins over SCRIBE_PORT, and the default is this backend's own port", () => {
  const base = { SCRIBE_SESSION_SECRET: "s" };
  assert.equal(configFromEnv(base).port, 8082);
  assert.equal(configFromEnv({ ...base, SCRIBE_PORT: "9001" }).port, 9001);
  assert.equal(configFromEnv({ ...base, SCRIBE_PORT: "9001", PORT: "9002" }).port, 9002);
  assert.throws(() => configFromEnv({ ...base, PORT: "http" }), ConfigError);
  assert.throws(() => configFromEnv({ ...base, PORT: "70000" }), ConfigError);
});

test("the currency must be one Meteroid knows", () => {
  const base = { SCRIBE_SESSION_SECRET: "s" };
  assert.equal(configFromEnv(base).defaultCurrency, Currency.Usd);
  assert.equal(configFromEnv({ ...base, SCRIBE_DEFAULT_CURRENCY: "eur" }).defaultCurrency, Currency.Eur);
  assert.throws(() => configFromEnv({ ...base, SCRIBE_DEFAULT_CURRENCY: "XYZ1" }), ConfigError);
});

// ---------------------------------------------------------------- decimals

test("billable minutes round up to two decimals", () => {
  assert.equal(billableMinutes(60), "1");
  assert.equal(billableMinutes(210), "3.5");
  // 100/60 = 1.666… must never round down: the demo bills what it used.
  assert.equal(billableMinutes(100), "1.67");
  assert.equal(billableMinutes(1), "0.02");
  assert.equal(billableMinutes(7200), "120");
});

test("decimal arithmetic is exact, and renders without trailing zeros", () => {
  assert.equal(normalize("3.50"), "3.5");
  assert.equal(normalize("600.000"), "600");
  assert.equal(normalize("-0.0"), "0");
  // The classic: 0.1 + 0.2 in binary floating point is 0.30000000000000004.
  assert.equal(add("0.1", "0.2"), "0.3");
  assert.equal(subtract("60", "56.5"), "3.5");
  assert.equal(subtract("1", "1.05"), "-0.05");
  // Beyond what a double can hold exactly.
  assert.equal(add("9007199254740993", "0.0000000001"), "9007199254740993.0000000001");
  assert.equal(greaterThan("3.51", "3.5"), true);
  assert.equal(greaterThan("3.50", "3.5"), false);
});

test("a value that is not an exact decimal is Meteroid's error, not a NaN", () => {
  for (const bad of ["1e3", "", "NaN", ".5", "1.", 12 as unknown as string]) {
    assert.throws(() => normalize(bad), (err) => err instanceof ApiError && err.code === "UPSTREAM_ERROR");
  }
});

// ---------------------------------------------------------------- quota

function metered(
  limit: string | null,
  consumed: string | null,
  remaining: string | null,
): MeteredEffectiveEntitlementValue {
  return {
    spec: { enabled: true, limit, metricId: "met_1", resetPeriod: { type: "BILLING_CYCLE" } },
    usage: { consumed, remaining },
  };
}

test("Meteroid's remaining is used when it has one", () => {
  const quota = quotaSnapshot("transcription_minutes", metered("60", "15", "45.0"));
  assert.equal(quota.remaining, "45");
  assert.equal(quota.unlimited, false);
});

test("remaining is derived when Meteroid has no counter", () => {
  assert.equal(quotaSnapshot("transcription_minutes", metered("60", "15", null)).remaining, "45");
  assert.equal(quotaSnapshot("transcription_minutes", metered("60", null, null)).remaining, "60");
});

test("an absent limit is unlimited, and every key is still there", () => {
  const quota = quotaSnapshot("transcription_minutes", metered(null, "900", null));
  assert.deepEqual(quota, {
    feature_code: "transcription_minutes",
    enabled: true,
    limit: null,
    consumed: "900",
    remaining: null,
    reset_at: null,
    unlimited: true,
  });
  // `deepEqual` treats a missing key and an `undefined` one alike; JSON does not.
  assert.equal(Object.keys(JSON.parse(JSON.stringify(quota))).length, 7);
});

const QUOTA: QuotaSnapshot = {
  feature_code: "transcription_minutes",
  enabled: true,
  limit: "60",
  consumed: "56.5",
  remaining: "3.5",
  reset_at: null,
  unlimited: false,
};

test("the quota is projected forward by what was billed", () => {
  const projected = projectQuota(QUOTA, billableMinutes(60));
  assert.equal(projected.consumed, "57.5");
  assert.equal(projected.remaining, "2.5");
});

test("an unlimited quota stays unlimited", () => {
  const projected = projectQuota(
    { ...QUOTA, limit: null, consumed: null, remaining: null, unlimited: true },
    billableMinutes(120),
  );
  assert.equal(projected.unlimited, true);
  assert.equal(projected.limit, null);
  assert.equal(projected.remaining, null);
  assert.equal(projected.consumed, "2");
});

// ---------------------------------------------------------------- labels

test("a metered limit is labelled with its reset period", () => {
  assert.equal(
    featureLabel("Transcription minutes", {
      type: "METERED",
      enabled: true,
      limit: "600.00",
      metricId: "met_1",
      resetPeriod: { type: "BILLING_CYCLE" },
    }),
    "600 transcription minutes per billing cycle",
  );
});

test("an unlimited entitlement is labelled as such", () => {
  assert.equal(
    featureLabel("Transcription minutes", {
      type: "METERED",
      enabled: true,
      metricId: "met_1",
      resetPeriod: { type: "BILLING_CYCLE" },
    }),
    "Unlimited transcription minutes",
  );
});

test("boolean and config entitlements are labelled", () => {
  assert.equal(featureLabel("SSO", { type: "BOOLEAN", enabled: true }), "SSO included");
  assert.equal(
    featureLabel("Retention days", { type: "CONFIG", value: { kind: "NUMBER", value: "90" } }),
    "90 retention days",
  );
});

// ---------------------------------------------------------------- wire shapes

test("nullable response fields are serialized as null, not omitted", () => {
  // Every optional SDK field absent — which the SDK reports as `undefined`, the one
  // value `JSON.stringify` drops. The shape must not change.
  const subscription: Subscription = {
    autoAdvanceInvoices: true,
    billingDayAnchor: 1,
    chargeAutomatically: true,
    createdAt: new Date("2026-09-01T12:00:00Z"),
    currency: Currency.Usd,
    currentPeriodStart: "2026-09-01",
    customProperties: {},
    customerId: "cus_1",
    customerName: "Acme",
    id: "sub_1",
    mrrCents: 0,
    netTerms: 0,
    period: BillingPeriodEnum.Monthly,
    planId: "plan_9",
    planName: "Something bespoke",
    planVersion: 1,
    planVersionId: "pv_9",
    startDate: "2026-09-01",
    status: SubscriptionStatusEnum.PendingActivation,
  };
  const wire = JSON.parse(JSON.stringify(projectSubscription(subscription, null)));

  assert.deepEqual(wire, {
    id: "sub_1",
    status: "PENDING_ACTIVATION",
    plan_code: null,
    plan_name: "Something bespoke",
    plan_version_id: "pv_9",
    currency: "USD",
    current_period_start: "2026-09-01",
    current_period_end: null,
    trial_duration_days: null,
    created_at: "2026-09-01T12:00:00.000Z",
  });

  const error = JSON.parse(JSON.stringify(ApiError.internal("boom")));
  assert.deepEqual(error, { code: "INTERNAL", message: "boom", quota: null, upgrade_plan_code: null });
});
