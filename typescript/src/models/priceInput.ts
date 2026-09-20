// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type Pricing, PricingSerializer } from "./pricing";

export interface PriceInput {
  cadence: BillingPeriodEnum;

  currency: string;

  pricing: Pricing;
}

export const PriceInputSerializer = {
  _fromJsonObject(object: any): PriceInput {
    return {
      cadence: BillingPeriodEnumSerializer._fromJsonObject(object["cadence"]),
      currency: object["currency"],
      pricing: PricingSerializer._fromJsonObject(object["pricing"]),
    };
  },

  _toJsonObject(self: PriceInput): any {
    return {
      cadence: BillingPeriodEnumSerializer._toJsonObject(self.cadence),
      currency: self.currency,
      pricing: PricingSerializer._toJsonObject(self.pricing),
    };
  },
};
