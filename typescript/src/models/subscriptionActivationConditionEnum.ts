// this file is @generated

export const SubscriptionActivationConditionEnum = {
  OnStart: "ON_START",
  OnCheckout: "ON_CHECKOUT",
  Manual: "MANUAL",
} as const;
export type SubscriptionActivationConditionEnum =
  | (typeof SubscriptionActivationConditionEnum)[keyof typeof SubscriptionActivationConditionEnum]
  | (string & {});

/** Converts `SubscriptionActivationConditionEnum` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionActivationConditionEnumSerializer = {
  parse(json: any): SubscriptionActivationConditionEnum {
    return json;
  },

  serialize(value: SubscriptionActivationConditionEnum): any {
    return value;
  },
};
