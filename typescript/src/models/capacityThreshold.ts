// this file is @generated
import { extraProperties } from "../json.js";

export interface CapacityThreshold {
  includedAmount: number;
  perUnitOverage: string;
  price: string;
}

/** Converts `CapacityThreshold` values from (`parse`) and to (`serialize`) their JSON form. */
export const CapacityThresholdSerializer = {
  parse(json: any): CapacityThreshold {
    return {
      ...extraProperties(json, ["included_amount", "per_unit_overage", "price"]),
      includedAmount: json["included_amount"],
      perUnitOverage: json["per_unit_overage"],
      price: json["price"],
    };
  },

  serialize(value: CapacityThreshold): any {
    return {
      ...extraProperties(value, ["includedAmount", "perUnitOverage", "price"]),
      included_amount: value.includedAmount,
      per_unit_overage: value.perUnitOverage,
      price: value.price,
    };
  },
};
