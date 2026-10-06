// this file is @generated
import { extraProperties } from "../json.js";

export interface OneTimeFee {
  quantity: number;
  rate: string;
}

/** Converts `OneTimeFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const OneTimeFeeSerializer = {
  parse(json: any): OneTimeFee {
    return {
      ...extraProperties(json, ["quantity", "rate"]),
      quantity: json["quantity"],
      rate: json["rate"],
    };
  },

  serialize(value: OneTimeFee): any {
    return {
      ...extraProperties(value, ["quantity", "rate"]),
      quantity: value.quantity,
      rate: value.rate,
    };
  },
};
