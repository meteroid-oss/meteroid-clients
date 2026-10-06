// this file is @generated

export const UnitConversionRoundingEnum = {
  Up: "UP",
  Down: "DOWN",
  Nearest: "NEAREST",
  NearestHalf: "NEAREST_HALF",
  NearestDecile: "NEAREST_DECILE",
  None: "NONE",
} as const;
export type UnitConversionRoundingEnum =
  | (typeof UnitConversionRoundingEnum)[keyof typeof UnitConversionRoundingEnum]
  | (string & {});

/** Converts `UnitConversionRoundingEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const UnitConversionRoundingEnumSerializer = {
  parse(json: any): UnitConversionRoundingEnum {
    return json;
  },

  serialize(value: UnitConversionRoundingEnum): any {
    return value;
  },
};
