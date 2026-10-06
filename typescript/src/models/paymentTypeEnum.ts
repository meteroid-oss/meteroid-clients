// this file is @generated

export const PaymentTypeEnum = {
  Payment: "PAYMENT",
  Refund: "REFUND",
} as const;
export type PaymentTypeEnum =
  | (typeof PaymentTypeEnum)[keyof typeof PaymentTypeEnum]
  | (string & {});

/** Converts `PaymentTypeEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const PaymentTypeEnumSerializer = {
  parse(json: any): PaymentTypeEnum {
    return json;
  },

  serialize(value: PaymentTypeEnum): any {
    return value;
  },
};
