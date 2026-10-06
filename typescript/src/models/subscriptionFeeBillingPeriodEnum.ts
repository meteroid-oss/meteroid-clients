// this file is @generated

export const SubscriptionFeeBillingPeriodEnum = {
  OneTime: "ONE_TIME",
  Monthly: "MONTHLY",
  Quarterly: "QUARTERLY",
  Semiannual: "SEMIANNUAL",
  Annual: "ANNUAL",
} as const;
export type SubscriptionFeeBillingPeriodEnum =
  | (typeof SubscriptionFeeBillingPeriodEnum)[keyof typeof SubscriptionFeeBillingPeriodEnum]
  | (string & {});

/** Converts `SubscriptionFeeBillingPeriodEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionFeeBillingPeriodEnumSerializer = {
  parse(json: any): SubscriptionFeeBillingPeriodEnum {
    return json;
  },

  serialize(value: SubscriptionFeeBillingPeriodEnum): any {
    return value;
  },
};
