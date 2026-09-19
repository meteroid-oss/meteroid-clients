/**
 * Turning Meteroid's effective entitlements into the contract's normalized view.
 *
 * This is the single most important piece of modelling in the demo, because it is what
 * both the UI gating and the server-side enforcement read.
 *
 * Meteroid's `EffectiveEntitlementValue` is a union tagged on `type`
 * (`BOOLEAN` / `METERED` / `CONFIG`), with the metered variant split into a `spec` (what
 * the plan grants) and a `usage` (what has been consumed). The contract keeps the tag,
 * flattens spec+usage into one object, and keeps every decimal a string.
 */

import type {
  ConfigValue as SdkConfigValue,
  EffectiveEntitlement,
  MeteredEffectiveEntitlementValue,
  ResetPeriod as SdkResetPeriod,
} from "@meteroid/sdk";

import { normalize, normalizeOpt, subtract } from "./decimal.js";
import {
  type ConfigValue,
  type Entitlement,
  type EntitlementValue,
  type QuotaSnapshot,
  type ResetPeriod,
  timestampOpt,
} from "./dto.js";
import { upstream } from "./error.js";
import type { AppState } from "./state.js";

/**
 * Read the workspace's effective entitlements from Meteroid.
 *
 * One call, by customer alias. Meteroid merges feature defaults, plan-version
 * entitlements, product and add-on entitlements, and attaches live usage counters.
 */
export async function fetchEntitlements(
  state: AppState,
  alias: string,
): Promise<EffectiveEntitlement[]> {
  const response = await state.meteroid.customers
    .getEffectiveEntitlements(alias)
    .catch(upstream(`GET /api/v1/customers/${alias}/entitlements`));

  return response.data;
}

/** Project one Meteroid entitlement onto the contract's tagged union. */
export async function normalizeEntitlement(
  state: AppState,
  entitlement: EffectiveEntitlement,
): Promise<Entitlement> {
  const { feature, value } = entitlement;

  let normalized: EntitlementValue;
  switch (value.type) {
    case "BOOLEAN":
      normalized = { type: "BOOLEAN", enabled: value.enabled };
      break;
    case "METERED": {
      // Meteroid names the metric behind an entitlement by id only. The code is
      // presentational (it lines this view up with `GET /api/usage`), so an
      // unresolvable id is a null rather than an error.
      const metricCode = await state.metrics.codeFor(state.meteroid, value.spec.metricId);
      const quota = quotaSnapshot(feature.code, value);

      normalized = {
        type: "METERED",
        enabled: quota.enabled,
        limit: quota.limit,
        consumed: quota.consumed,
        remaining: quota.remaining,
        unlimited: quota.unlimited,
        reset_at: quota.reset_at,
        reset_period: resetPeriod(value.spec.resetPeriod),
        metric_code: metricCode,
      };
      break;
    }
    case "CONFIG":
      normalized = { type: "CONFIG", value: configValue(value.value) };
      break;
  }

  return { feature_code: feature.code, feature_name: feature.name, value: normalized };
}

/**
 * The consumption state of a metered entitlement, as both the entitlement view and the
 * quota-exhausted error report it.
 *
 * `remaining` is the number the quota check compares against, and Meteroid does not
 * always supply it: `MeteredEntitlementUsage` requires none of its properties, so an
 * entitlement whose counter has not been written yet arrives with `remaining` absent
 * but `limit` set. The contract therefore fixes the fallback — `limit - consumed`, then
 * `limit` — so that a limited entitlement always reports a balance and no two backends
 * can disagree about it.
 */
export function quotaSnapshot(
  featureCode: string,
  metered: MeteredEffectiveEntitlementValue,
): QuotaSnapshot {
  const { spec, usage } = metered;

  return {
    feature_code: featureCode,
    enabled: spec.enabled,
    limit: normalizeOpt(spec.limit),
    consumed: normalizeOpt(usage.consumed),
    remaining: remainingBalance(spec.limit, usage.consumed, usage.remaining),
    reset_at: timestampOpt(usage.resetAt),
    // A null limit is Meteroid's way of saying "unlimited"; mirroring it as a boolean
    // saves every client the same null special-case.
    unlimited: spec.limit == null,
  };
}

/**
 * Exact decimal arithmetic, never binary floating point — this is money. The SDK types
 * all three as `string`, and they stay strings all the way through `decimal.ts`.
 */
export function remainingBalance(
  limit: string | null | undefined,
  consumed: string | null | undefined,
  reported: string | null | undefined,
): string | null {
  if (limit == null) {
    return null;
  }
  return reported != null ? normalize(reported) : subtract(limit, consumed ?? "0");
}

/**
 * Meteroid models the reset period as its own five-variant tagged union, but every
 * variant beyond the tag carries at most an `interval`+`unit` pair. The contract keeps
 * the tag and nullable fields rather than nesting a second union inside the first.
 */
function resetPeriod(period: SdkResetPeriod): ResetPeriod {
  switch (period.type) {
    case "BILLING_CYCLE":
    case "NEVER":
      return { type: period.type, interval: null, unit: null };
    case "CALENDAR":
    case "FIXED_WINDOW":
    case "SLIDING_WINDOW":
      return { type: period.type, interval: period.interval, unit: period.unit };
  }
}

/**
 * Meteroid's `ConfigValueType` also lists `MAP` and `SELECT`, but its `ConfigValue`
 * union carries only these four, which is exactly the set the contract exposes.
 */
function configValue(value: SdkConfigValue): ConfigValue {
  switch (value.kind) {
    // Numbers stay decimal strings: Meteroid types this `format: decimal`.
    case "NUMBER":
      return { kind: "NUMBER", value: normalize(value.value) };
    case "BOOLEAN":
      return { kind: "BOOLEAN", value: value.value };
    case "TEXT":
      return { kind: "TEXT", value: value.value };
    case "JSON":
      // `undefined` is the one value `JSON.stringify` would drop the key for.
      return { kind: "JSON", value: value.value ?? null };
  }
}
