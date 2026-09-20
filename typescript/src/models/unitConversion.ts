// this file is @generated
import {
  type UnitConversionRoundingEnum,
  UnitConversionRoundingEnumSerializer,
} from "./unitConversionRoundingEnum";

export interface UnitConversion {
  factor: number;

  rounding: UnitConversionRoundingEnum;
}

export const UnitConversionSerializer = {
  _fromJsonObject(object: any): UnitConversion {
    return {
      factor: object["factor"],
      rounding: UnitConversionRoundingEnumSerializer._fromJsonObject(object["rounding"]),
    };
  },

  _toJsonObject(self: UnitConversion): any {
    return {
      factor: self.factor,
      rounding: UnitConversionRoundingEnumSerializer._toJsonObject(self.rounding),
    };
  },
};
