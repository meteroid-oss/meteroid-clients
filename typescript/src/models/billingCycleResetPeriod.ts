// this file is @generated
import { extraProperties } from "../json.js";
/** Resets each time your subscription renews — anchored to your billing cycle. */
export interface BillingCycleResetPeriod {}

/** Converts `BillingCycleResetPeriod` values from (`parse`) and to (`serialize`) their JSON form. */
export const BillingCycleResetPeriodSerializer = {
  parse(json: any): BillingCycleResetPeriod {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: BillingCycleResetPeriod): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
