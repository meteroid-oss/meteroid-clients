// this file is @generated
import { extraProperties } from "../json.js";
import {
  type UnitConversionRoundingEnum,
  UnitConversionRoundingEnumSerializer,
} from "./unitConversionRoundingEnum.js";

export interface UnitConversion {
  factor: number;
  rounding: UnitConversionRoundingEnum;
}

/** Converts `UnitConversion` values from (`parse`) and to (`serialize`) their JSON form. */
export const UnitConversionSerializer = {
  parse(json: any): UnitConversion {
    return {
      ...extraProperties(json, ["factor", "rounding"]),
      factor: json["factor"],
      rounding: UnitConversionRoundingEnumSerializer.parse(json["rounding"]),
    };
  },

  serialize(value: UnitConversion): any {
    return {
      ...extraProperties(value, ["factor", "rounding"]),
      factor: value.factor,
      rounding: UnitConversionRoundingEnumSerializer.serialize(value.rounding),
    };
  },
};
