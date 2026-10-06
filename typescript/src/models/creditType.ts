// this file is @generated

export const CreditType = {
  CreditToBalance: "CREDIT_TO_BALANCE",
  Refund: "REFUND",
  DebtCancellation: "DEBT_CANCELLATION",
} as const;
export type CreditType = (typeof CreditType)[keyof typeof CreditType] | (string & {});

/** Converts `CreditType` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreditTypeSerializer = {
  parse(json: any): CreditType {
    return json;
  },

  serialize(value: CreditType): any {
    return value;
  },
};
