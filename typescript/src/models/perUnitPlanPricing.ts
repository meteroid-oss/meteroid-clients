// this file is @generated
import { extraProperties } from "../json.js";

export interface PerUnitPlanPricing {
  rate: string;
}

/** Converts `PerUnitPlanPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const PerUnitPlanPricingSerializer = {
  parse(json: any): PerUnitPlanPricing {
    return {
      ...extraProperties(json, ["rate"]),
      rate: json["rate"],
    };
  },

  serialize(value: PerUnitPlanPricing): any {
    return {
      ...extraProperties(value, ["rate"]),
      rate: value.rate,
    };
  },
};
