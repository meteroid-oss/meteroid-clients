// this file is @generated
import { extraProperties } from "../json.js";

export interface CancelSubscriptionRequest {
  /** If not provided, the cancellation will be effective at the end of the current billing or committed period. */
  effectiveDate?: string | null | undefined;
  reason?: string | null | undefined;
}

/** Converts `CancelSubscriptionRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CancelSubscriptionRequestSerializer = {
  parse(json: any): CancelSubscriptionRequest {
    return {
      ...extraProperties(json, ["effective_date", "reason"]),
      effectiveDate: json["effective_date"],
      reason: json["reason"],
    };
  },

  serialize(value: CancelSubscriptionRequest): any {
    return {
      ...extraProperties(value, ["effectiveDate", "reason"]),
      effective_date: value.effectiveDate,
      reason: value.reason,
    };
  },
};
