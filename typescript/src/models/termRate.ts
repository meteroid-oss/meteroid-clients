// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";

export interface TermRate {
  price: string;

  term: BillingPeriodEnum;
}

export const TermRateSerializer = {
  _fromJsonObject(object: any): TermRate {
    return {
      price: object["price"],
      term: BillingPeriodEnumSerializer._fromJsonObject(object["term"]),
    };
  },

  _toJsonObject(self: TermRate): any {
    return {
      price: self.price,
      term: BillingPeriodEnumSerializer._toJsonObject(self.term),
    };
  },
};
