import type { ResourceState, ResourceStatus } from "./client";
import { compareDecimal } from "./decimal";
import type { ConfigValue } from "./models/configValue";
import type { EffectiveEntitlement } from "./models/effectiveEntitlement";
import type { MeteredEntitlementUsage } from "./models/meteredEntitlementUsage";

/** Usage of a metered feature. Decimals are strings, as sent by the API. */
export interface EntitlementUsage {
  consumed?: string;
  /** Absent when the feature is unlimited. */
  limit?: string;
  remaining?: string;
  resetAt?: Date;
  /** A limit applies but the API sent no usage figures, so access is granted. */
  unknown: boolean;
}

/** Whether the customer can use a feature, and what the answer is based on. */
export interface EntitlementCheck {
  status: ResourceStatus;
  hasAccess: boolean;
  /** `hasAccess` is the `fallback` option: the entitlements are not loaded (yet). */
  isFallback: boolean;
  /** Absent when the customer has no entitlement for this feature. */
  entitlement: EffectiveEntitlement | undefined;
  /** Metered features only. */
  usage?: EntitlementUsage;
  /** Config features only. */
  value?: ConfigValue;
}

export interface CheckOptions {
  /** `hasAccess` while the entitlements are loading or failed to load. Default `false`. */
  fallback?: boolean;
}

function meteredUsage(
  limit: string | null | undefined,
  usage: MeteredEntitlementUsage | undefined
): EntitlementUsage {
  const result: EntitlementUsage = {
    consumed: usage?.consumed ?? undefined,
    limit: limit ?? undefined,
    remaining: usage?.remaining ?? undefined,
    resetAt: usage?.resetAt ?? undefined,
    unknown: false,
  };
  result.unknown =
    result.limit !== undefined &&
    result.consumed === undefined &&
    result.remaining === undefined;
  return result;
}

function meteredAccess({
  consumed,
  limit,
  remaining,
  unknown,
}: EntitlementUsage): boolean {
  if (limit === undefined || unknown) {
    return true;
  }
  if (remaining !== undefined) {
    return (compareDecimal(remaining, "0") ?? 0) > 0;
  }
  return (compareDecimal(consumed!, limit) ?? 0) < 0;
}

/**
 * Evaluate a feature: Boolean needs `enabled`; Metered needs `enabled` and headroom (no limit,
 * `remaining > 0`, `consumed < limit`, or no usage figures); Config needs to be present.
 */
export function checkEntitlement(
  entitlements: ResourceState<EffectiveEntitlement[]>,
  featureCode: string,
  options?: CheckOptions
): EntitlementCheck {
  const { status, data } = entitlements;
  if (data === undefined) {
    return {
      status,
      hasAccess: options?.fallback ?? false,
      isFallback: true,
      entitlement: undefined,
    };
  }
  const entitlement = data.find((item) => item.feature.code === featureCode);
  const result: EntitlementCheck = {
    status,
    hasAccess: false,
    isFallback: false,
    entitlement,
  };
  const value = entitlement?.value;
  if (value?.type === "BOOLEAN") {
    result.hasAccess = value.enabled === true;
  } else if (value?.type === "METERED") {
    result.usage = meteredUsage(value.spec.limit, value.usage);
    result.hasAccess = value.spec.enabled === true && meteredAccess(result.usage);
  } else if (value?.type === "CONFIG") {
    result.hasAccess = true;
    result.value = value.value;
  }
  return result;
}
