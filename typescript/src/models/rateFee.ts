// this file is @generated
import { extraProperties } from "../json.js";

export interface RateFee {
  rate: string;
}

/** Converts `RateFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const RateFeeSerializer = {
  parse(json: any): RateFee {
    return {
      ...extraProperties(json, ["rate"]),
      rate: json["rate"],
    };
  },

  serialize(value: RateFee): any {
    return {
      ...extraProperties(value, ["rate"]),
      rate: value.rate,
    };
  },
};
