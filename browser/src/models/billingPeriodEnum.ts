// this file is @generated

export enum BillingPeriodEnum {
  Monthly = "MONTHLY",
  Quarterly = "QUARTERLY",
  Semiannual = "SEMIANNUAL",
  Annual = "ANNUAL",
}

export const BillingPeriodEnumSerializer = {
  _fromJsonObject(object: any): BillingPeriodEnum {
    return object;
  },

  _toJsonObject(self: BillingPeriodEnum): any {
    return self;
  },
};
