// this file is @generated

export enum CustomPropertyEntityType {
  Customer = "CUSTOMER",
  Subscription = "SUBSCRIPTION",
  Invoice = "INVOICE",
  CreditNote = "CREDIT_NOTE",
}

export const CustomPropertyEntityTypeSerializer = {
  _fromJsonObject(object: any): CustomPropertyEntityType {
    return object;
  },

  _toJsonObject(self: CustomPropertyEntityType): any {
    return self;
  },
};
