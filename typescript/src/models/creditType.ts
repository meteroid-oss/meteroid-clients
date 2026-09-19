// this file is @generated

export enum CreditType {
  CreditToBalance = "CREDIT_TO_BALANCE",
  Refund = "REFUND",
  DebtCancellation = "DEBT_CANCELLATION",
}

export const CreditTypeSerializer = {
  _fromJsonObject(object: any): CreditType {
    return object;
  },

  _toJsonObject(self: CreditType): any {
    return self;
  },
};
