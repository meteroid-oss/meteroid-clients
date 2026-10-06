// this file is @generated
import { extraProperties } from "../json.js";

export interface FixedDiscount {
  amount: string;
  currency: string;
}

/** Converts `FixedDiscount` values from (`parse`) and to (`serialize`) their JSON form. */
export const FixedDiscountSerializer = {
  parse(json: any): FixedDiscount {
    return {
      ...extraProperties(json, ["amount", "currency"]),
      amount: json["amount"],
      currency: json["currency"],
    };
  },

  serialize(value: FixedDiscount): any {
    return {
      ...extraProperties(value, ["amount", "currency"]),
      amount: value.amount,
      currency: value.currency,
    };
  },
};
