// this file is @generated

export enum UnitConversionRoundingEnum {
  Up = "UP",
  Down = "DOWN",
  Nearest = "NEAREST",
  NearestHalf = "NEAREST_HALF",
  NearestDecile = "NEAREST_DECILE",
  None = "NONE",
}

export const UnitConversionRoundingEnumSerializer = {
  _fromJsonObject(object: any): UnitConversionRoundingEnum {
    return object;
  },

  _toJsonObject(self: UnitConversionRoundingEnum): any {
    return self;
  },
};
