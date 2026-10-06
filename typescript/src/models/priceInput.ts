// this file is @generated
import { extraProperties } from "../json.js";
import {
  type BillingPeriodEnum,
  BillingPeriodEnumSerializer,
} from "./billingPeriodEnum.js";
import { type Pricing, PricingSerializer } from "./pricing.js";

export interface PriceInput {
  cadence: BillingPeriodEnum;
  currency: string;
  pricing: Pricing;
}

/** Converts `PriceInput` values from (`parse`) and to (`serialize`) their JSON form. */
export const PriceInputSerializer = {
  parse(json: any): PriceInput {
    return {
      ...extraProperties(json, ["cadence", "currency", "pricing"]),
      cadence: BillingPeriodEnumSerializer.parse(json["cadence"]),
      currency: json["currency"],
      pricing: PricingSerializer.parse(json["pricing"]),
    };
  },

  serialize(value: PriceInput): any {
    return {
      ...extraProperties(value, ["cadence", "currency", "pricing"]),
      cadence: BillingPeriodEnumSerializer.serialize(value.cadence),
      currency: value.currency,
      pricing: PricingSerializer.serialize(value.pricing),
    };
  },
};
