// this file is @generated

export enum SubscriptionFeeBillingPeriodEnum {
  OneTime = "ONE_TIME",
  Monthly = "MONTHLY",
  Quarterly = "QUARTERLY",
  Semiannual = "SEMIANNUAL",
  Annual = "ANNUAL",
}

export const SubscriptionFeeBillingPeriodEnumSerializer = {
  _fromJsonObject(object: any): SubscriptionFeeBillingPeriodEnum {
    return object;
  },

  _toJsonObject(self: SubscriptionFeeBillingPeriodEnum): any {
    return self;
  },
};
