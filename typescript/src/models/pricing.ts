// this file is @generated
import { type CapacityPricing, CapacityPricingSerializer } from "./capacityPricing.js";
import {
  type ExtraRecurringPricing,
  ExtraRecurringPricingSerializer,
} from "./extraRecurringPricing.js";
import { type OneTimePricing, OneTimePricingSerializer } from "./oneTimePricing.js";
import { type RatePricing, RatePricingSerializer } from "./ratePricing.js";
import { type SlotPricing, SlotPricingSerializer } from "./slotPricing.js";
import { type UsagePricing, UsagePricingSerializer } from "./usagePricing.js";

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

/** Converts `Pricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const PricingSerializer = {
  parse(json: any): Pricing {
    switch (json["type"]) {
      case "RATE":
        return {
          ...RatePricingSerializer.parse(json),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPricingSerializer.parse(json),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPricingSerializer.parse(json),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePricingSerializer.parse(json),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPricingSerializer.parse(json),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePricingSerializer.parse(json),
          type: "ONE_TIME",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: Pricing): any {
    switch (value.type) {
      case "RATE":
        return {
          ...RatePricingSerializer.serialize(value),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPricingSerializer.serialize(value),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPricingSerializer.serialize(value),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePricingSerializer.serialize(value),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPricingSerializer.serialize(value),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePricingSerializer.serialize(value),
          type: "ONE_TIME",
        };
      default:
        return value;
    }
  },
};
