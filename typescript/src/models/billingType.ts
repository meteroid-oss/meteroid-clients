// this file is @generated

export const BillingType = {
  Advance: "ADVANCE",
  Arrears: "ARREARS",
} as const;
export type BillingType = (typeof BillingType)[keyof typeof BillingType] | (string & {});

/** Converts `BillingType` values from (`parse`) and to (`serialize`) their JSON form. */
export const BillingTypeSerializer = {
  parse(json: any): BillingType {
    return json;
  },

  serialize(value: BillingType): any {
    return value;
  },
};
