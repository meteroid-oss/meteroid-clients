// this file is @generated

export const CustomPropertyEntityType = {
  Customer: "CUSTOMER",
  Subscription: "SUBSCRIPTION",
  Invoice: "INVOICE",
  CreditNote: "CREDIT_NOTE",
} as const;
export type CustomPropertyEntityType =
  | (typeof CustomPropertyEntityType)[keyof typeof CustomPropertyEntityType]
  | (string & {});

/** Converts `CustomPropertyEntityType` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomPropertyEntityTypeSerializer = {
  parse(json: any): CustomPropertyEntityType {
    return json;
  },

  serialize(value: CustomPropertyEntityType): any {
    return value;
  },
};
