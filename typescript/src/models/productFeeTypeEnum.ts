// this file is @generated

export const ProductFeeTypeEnum = {
  Rate: "RATE",
  Slot: "SLOT",
  Capacity: "CAPACITY",
  Usage: "USAGE",
  ExtraRecurring: "EXTRA_RECURRING",
  OneTime: "ONE_TIME",
} as const;
export type ProductFeeTypeEnum =
  | (typeof ProductFeeTypeEnum)[keyof typeof ProductFeeTypeEnum]
  | (string & {});

/** Converts `ProductFeeTypeEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductFeeTypeEnumSerializer = {
  parse(json: any): ProductFeeTypeEnum {
    return json;
  },

  serialize(value: ProductFeeTypeEnum): any {
    return value;
  },
};
