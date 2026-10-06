// this file is @generated
import { extraProperties } from "../json.js";

export interface TierRow {
  firstUnit: number;
  flatCap?: string | null | undefined;
  flatFee?: string | null | undefined;
  rate: string;
}

/** Converts `TierRow` values from (`parse`) and to (`serialize`) their JSON form. */
export const TierRowSerializer = {
  parse(json: any): TierRow {
    return {
      ...extraProperties(json, ["first_unit", "flat_cap", "flat_fee", "rate"]),
      firstUnit: json["first_unit"],
      flatCap: json["flat_cap"],
      flatFee: json["flat_fee"],
      rate: json["rate"],
    };
  },

  serialize(value: TierRow): any {
    return {
      ...extraProperties(value, ["firstUnit", "flatCap", "flatFee", "rate"]),
      first_unit: value.firstUnit,
      flat_cap: value.flatCap,
      flat_fee: value.flatFee,
      rate: value.rate,
    };
  },
};
