// this file is @generated
import { extraProperties } from "../json.js";

export interface PercentageDiscount {
  percentage: string;
}

/** Converts `PercentageDiscount` values from (`parse`) and to (`serialize`) their JSON form. */
export const PercentageDiscountSerializer = {
  parse(json: any): PercentageDiscount {
    return {
      ...extraProperties(json, ["percentage"]),
      percentage: json["percentage"],
    };
  },

  serialize(value: PercentageDiscount): any {
    return {
      ...extraProperties(value, ["percentage"]),
      percentage: value.percentage,
    };
  },
};
