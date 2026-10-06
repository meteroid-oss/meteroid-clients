// this file is @generated

export const BillingPeriodEnum = {
  Monthly: "MONTHLY",
  Quarterly: "QUARTERLY",
  Semiannual: "SEMIANNUAL",
  Annual: "ANNUAL",
} as const;
export type BillingPeriodEnum =
  | (typeof BillingPeriodEnum)[keyof typeof BillingPeriodEnum]
  | (string & {});

/** Converts `BillingPeriodEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const BillingPeriodEnumSerializer = {
  parse(json: any): BillingPeriodEnum {
    return json;
  },

  serialize(value: BillingPeriodEnum): any {
    return value;
  },
};
