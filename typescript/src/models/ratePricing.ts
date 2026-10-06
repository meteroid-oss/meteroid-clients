// this file is @generated
import { extraProperties } from "../json.js";

export interface RatePricing {
  rate: string;
}

/** Converts `RatePricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const RatePricingSerializer = {
  parse(json: any): RatePricing {
    return {
      ...extraProperties(json, ["rate"]),
      rate: json["rate"],
    };
  },

  serialize(value: RatePricing): any {
    return {
      ...extraProperties(value, ["rate"]),
      rate: value.rate,
    };
  },
};
