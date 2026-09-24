import { parseDateTime } from "../datetime";

export interface MeteredEntitlementUsage {
  consumed?: string | null;

  remaining?: string | null;

  resetAt?: Date | null;
}

export const MeteredEntitlementUsageSerializer = {
  _fromJsonObject(object: any): MeteredEntitlementUsage {
    return {
      consumed: object["consumed"],
      remaining: object["remaining"],
      resetAt: object["reset_at"] != null ? parseDateTime(object["reset_at"]) : undefined,
    };
  },

  _toJsonObject(self: MeteredEntitlementUsage): any {
    return {
      consumed: self.consumed,
      remaining: self.remaining,
      reset_at: self.resetAt,
    };
  },
};
