// this file is @generated

export enum PaymentMethodTypeEnum {
  Card = "CARD",
  BankTransfer = "BANK_TRANSFER",
  Wallet = "WALLET",
  Other = "OTHER",
}

export const PaymentMethodTypeEnumSerializer = {
  _fromJsonObject(object: any): PaymentMethodTypeEnum {
    return object;
  },

  _toJsonObject(self: PaymentMethodTypeEnum): any {
    return self;
  },
};
