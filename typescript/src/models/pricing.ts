// this file is @generated
import { type CapacityPricing, CapacityPricingSerializer } from "./capacityPricing";
import {
  type ExtraRecurringPricing,
  ExtraRecurringPricingSerializer,
} from "./extraRecurringPricing";
import { type OneTimePricing, OneTimePricingSerializer } from "./oneTimePricing";
import { type RatePricing, RatePricingSerializer } from "./ratePricing";
import { type SlotPricing, SlotPricingSerializer } from "./slotPricing";
import { type UsagePricing, UsagePricingSerializer } from "./usagePricing";

export interface PricingRate extends RatePricing {
  type: "RATE";
}
export interface PricingSlot extends SlotPricing {
  type: "SLOT";
}
export interface PricingCapacity extends CapacityPricing {
  type: "CAPACITY";
}
export interface PricingUsage extends UsagePricing {
  type: "USAGE";
}
export interface PricingExtraRecurring extends ExtraRecurringPricing {
  type: "EXTRA_RECURRING";
}
export interface PricingOneTime extends OneTimePricing {
  type: "ONE_TIME";
}

export type Pricing =
  | PricingRate
  | PricingSlot
  | PricingCapacity
  | PricingUsage
  | PricingExtraRecurring
  | PricingOneTime;

export const PricingSerializer = {
  _fromJsonObject(object: any): Pricing {
    const type = object["type"];

    switch (type) {
      case "RATE":
        return {
          ...RatePricingSerializer._fromJsonObject(object),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPricingSerializer._fromJsonObject(object),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPricingSerializer._fromJsonObject(object),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePricingSerializer._fromJsonObject(object),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPricingSerializer._fromJsonObject(object),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePricingSerializer._fromJsonObject(object),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for Pricing: ${type}`);
    }
  },

  _toJsonObject(self: Pricing): any {
    switch (self.type) {
      case "RATE":
        return {
          ...RatePricingSerializer._toJsonObject(self),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPricingSerializer._toJsonObject(self),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPricingSerializer._toJsonObject(self),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePricingSerializer._toJsonObject(self),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPricingSerializer._toJsonObject(self),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePricingSerializer._toJsonObject(self),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for Pricing`);
    }
  },
};
