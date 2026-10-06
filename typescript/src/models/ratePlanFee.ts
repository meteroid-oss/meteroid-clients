// this file is @generated
import { extraProperties } from "../json.js";
import { type TermRate, TermRateSerializer } from "./termRate.js";
/** Recurring rate fee (e.g., monthly subscription) */
export interface RatePlanFee {
  rates: TermRate[];
}

/** Converts `RatePlanFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const RatePlanFeeSerializer = {
  parse(json: any): RatePlanFee {
    return {
      ...extraProperties(json, ["rates"]),
      rates: json["rates"].map((item: any) => TermRateSerializer.parse(item)),
    };
  },

  serialize(value: RatePlanFee): any {
    return {
      ...extraProperties(value, ["rates"]),
      rates: value.rates.map((item: any) => TermRateSerializer.serialize(item)),
    };
  },
};
