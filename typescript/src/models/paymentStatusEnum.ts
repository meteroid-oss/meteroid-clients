// this file is @generated

export const PaymentStatusEnum = {
  Ready: "READY",
  Pending: "PENDING",
  Settled: "SETTLED",
  Cancelled: "CANCELLED",
  Failed: "FAILED",
  Refunded: "REFUNDED",
} as const;
export type PaymentStatusEnum =
  | (typeof PaymentStatusEnum)[keyof typeof PaymentStatusEnum]
  | (string & {});

/** Converts `PaymentStatusEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const PaymentStatusEnumSerializer = {
  parse(json: any): PaymentStatusEnum {
    return json;
  },

  serialize(value: PaymentStatusEnum): any {
    return value;
  },
};
