// this file is @generated
import { extraProperties } from "../json.js";

export interface ExtraRecurringPricing {
  quantity: number;
  unitPrice: string;
}

/** Converts `ExtraRecurringPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const ExtraRecurringPricingSerializer = {
  parse(json: any): ExtraRecurringPricing {
    return {
      ...extraProperties(json, ["quantity", "unit_price"]),
      quantity: json["quantity"],
      unitPrice: json["unit_price"],
    };
  },

  serialize(value: ExtraRecurringPricing): any {
    return {
      ...extraProperties(value, ["quantity", "unitPrice"]),
      quantity: value.quantity,
      unit_price: value.unitPrice,
    };
  },
};
