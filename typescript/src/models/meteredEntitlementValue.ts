// this file is @generated
import { extraProperties } from "../json.js";
import { type ResetPeriod, ResetPeriodSerializer } from "./resetPeriod.js";

export interface MeteredEntitlementValue {
  /** Per-entitlement kill switch. `false` means disabled. */
  enabled?: boolean | undefined;
  /** Cap on usage. Null means unlimited. */
  limit?: string | null | undefined;
  resetPeriod?: ResetPeriod | undefined;
}

/** Converts `MeteredEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const MeteredEntitlementValueSerializer = {
  parse(json: any): MeteredEntitlementValue {
    return {
      ...extraProperties(json, ["enabled", "limit", "reset_period"]),
      enabled: json["enabled"],
      limit: json["limit"],
      resetPeriod:
        json["reset_period"] != null
          ? ResetPeriodSerializer.parse(json["reset_period"])
          : undefined,
    };
  },

  serialize(value: MeteredEntitlementValue): any {
    return {
      ...extraProperties(value, ["enabled", "limit", "resetPeriod"]),
      enabled: value.enabled,
      limit: value.limit,
      reset_period:
        value.resetPeriod != null
          ? ResetPeriodSerializer.serialize(value.resetPeriod)
          : undefined,
    };
  },
};
