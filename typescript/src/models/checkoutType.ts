// this file is @generated

export const CheckoutType = {
  SelfServe: "SELF_SERVE",
  SubscriptionActivation: "SUBSCRIPTION_ACTIVATION",
  PlanChange: "PLAN_CHANGE",
  AddonPurchase: "ADDON_PURCHASE",
} as const;
export type CheckoutType =
  | (typeof CheckoutType)[keyof typeof CheckoutType]
  | (string & {});

/** Converts `CheckoutType` values from (`parse`) and to (`serialize`) their JSON form. */
export const CheckoutTypeSerializer = {
  parse(json: any): CheckoutType {
    return json;
  },

  serialize(value: CheckoutType): any {
    return value;
  },
};
