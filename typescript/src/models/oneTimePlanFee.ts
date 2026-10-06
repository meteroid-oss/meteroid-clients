// this file is @generated
import { extraProperties } from "../json.js";
/** One-time fee */
export interface OneTimePlanFee {
  quantity: number;
  unitPrice: string;
}

/** Converts `OneTimePlanFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const OneTimePlanFeeSerializer = {
  parse(json: any): OneTimePlanFee {
    return {
      ...extraProperties(json, ["quantity", "unit_price"]),
      quantity: json["quantity"],
      unitPrice: json["unit_price"],
    };
  },

  serialize(value: OneTimePlanFee): any {
    return {
      ...extraProperties(value, ["quantity", "unitPrice"]),
      quantity: value.quantity,
      unit_price: value.unitPrice,
    };
  },
};
