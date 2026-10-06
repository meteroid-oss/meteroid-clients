// this file is @generated

export const BillingTypeEnum = {
  Advance: "ADVANCE",
  Arrears: "ARREARS",
} as const;
export type BillingTypeEnum =
  | (typeof BillingTypeEnum)[keyof typeof BillingTypeEnum]
  | (string & {});

/** Converts `BillingTypeEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const BillingTypeEnumSerializer = {
  parse(json: any): BillingTypeEnum {
    return json;
  },

  serialize(value: BillingTypeEnum): any {
    return value;
  },
};
