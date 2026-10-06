// this file is @generated
import { extraProperties } from "../json.js";

export interface CapacityPricing {
  included: number;
  overageRate: string;
  rate: string;
}

/** Converts `CapacityPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const CapacityPricingSerializer = {
  parse(json: any): CapacityPricing {
    return {
      ...extraProperties(json, ["included", "overage_rate", "rate"]),
      included: json["included"],
      overageRate: json["overage_rate"],
      rate: json["rate"],
    };
  },

  serialize(value: CapacityPricing): any {
    return {
      ...extraProperties(value, ["included", "overageRate", "rate"]),
      included: value.included,
      overage_rate: value.overageRate,
      rate: value.rate,
    };
  },
};
