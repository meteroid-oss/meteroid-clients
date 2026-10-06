// this file is @generated
import { extraProperties } from "../json.js";

export interface OneTimePricing {
  quantity: number;
  unitPrice: string;
}

/** Converts `OneTimePricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const OneTimePricingSerializer = {
  parse(json: any): OneTimePricing {
    return {
      ...extraProperties(json, ["quantity", "unit_price"]),
      quantity: json["quantity"],
      unitPrice: json["unit_price"],
    };
  },

  serialize(value: OneTimePricing): any {
    return {
      ...extraProperties(value, ["quantity", "unitPrice"]),
      quantity: value.quantity,
      unit_price: value.unitPrice,
    };
  },
};
