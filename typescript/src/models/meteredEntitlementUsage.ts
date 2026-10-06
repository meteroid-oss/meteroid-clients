// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";

export interface MeteredEntitlementUsage {
  consumed?: string | null | undefined;
  remaining?: string | null | undefined;
  resetAt?: Date | null | undefined;
}

/** Converts `MeteredEntitlementUsage` values from (`parse`) and to (`serialize`) their JSON form. */
export const MeteredEntitlementUsageSerializer = {
  parse(json: any): MeteredEntitlementUsage {
    return {
      ...extraProperties(json, ["consumed", "remaining", "reset_at"]),
      consumed: json["consumed"],
      remaining: json["remaining"],
      resetAt:
        json["reset_at"] != null ? parseDateTime(json["reset_at"]) : json["reset_at"],
    };
  },

  serialize(value: MeteredEntitlementUsage): any {
    return {
      ...extraProperties(value, ["consumed", "remaining", "resetAt"]),
      consumed: value.consumed,
      remaining: value.remaining,
      reset_at: value.resetAt,
    };
  },
};
