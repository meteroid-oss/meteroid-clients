// this file is @generated
import { extraProperties } from "../json.js";

export interface PerUnitPricing {
  rate: string;
}

/** Converts `PerUnitPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const PerUnitPricingSerializer = {
  parse(json: any): PerUnitPricing {
    return {
      ...extraProperties(json, ["rate"]),
      rate: json["rate"],
    };
  },

  serialize(value: PerUnitPricing): any {
    return {
      ...extraProperties(value, ["rate"]),
      rate: value.rate,
    };
  },
};
