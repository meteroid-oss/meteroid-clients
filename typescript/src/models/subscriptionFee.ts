// this file is @generated
import { type CapacityFee, CapacityFeeSerializer } from "./capacityFee.js";
import { type OneTimeFee, OneTimeFeeSerializer } from "./oneTimeFee.js";
import { type RateFee, RateFeeSerializer } from "./rateFee.js";
import { type RecurringFee, RecurringFeeSerializer } from "./recurringFee.js";
import { type SlotFee, SlotFeeSerializer } from "./slotFee.js";
import { type UsageFee, UsageFeeSerializer } from "./usageFee.js";

export interface SubscriptionFeeRate extends RateFee {
  type: "RATE";
}
export interface SubscriptionFeeOneTime extends OneTimeFee {
  type: "ONE_TIME";
}
export interface SubscriptionFeeRecurring extends RecurringFee {
  type: "RECURRING";
}
export interface SubscriptionFeeCapacity extends CapacityFee {
  type: "CAPACITY";
}
export interface SubscriptionFeeSlot extends SlotFee {
  type: "SLOT";
}
export interface SubscriptionFeeUsage extends UsageFee {
  type: "USAGE";
}

export type SubscriptionFee =
  | SubscriptionFeeRate
  | SubscriptionFeeOneTime
  | SubscriptionFeeRecurring
  | SubscriptionFeeCapacity
  | SubscriptionFeeSlot
  | SubscriptionFeeUsage;

/** Converts `SubscriptionFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionFeeSerializer = {
  parse(json: any): SubscriptionFee {
    switch (json["type"]) {
      case "RATE":
        return {
          ...RateFeeSerializer.parse(json),
          type: "RATE",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeSerializer.parse(json),
          type: "ONE_TIME",
        };
      case "RECURRING":
        return {
          ...RecurringFeeSerializer.parse(json),
          type: "RECURRING",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeSerializer.parse(json),
          type: "CAPACITY",
        };
      case "SLOT":
        return {
          ...SlotFeeSerializer.parse(json),
          type: "SLOT",
        };
      case "USAGE":
        return {
          ...UsageFeeSerializer.parse(json),
          type: "USAGE",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: SubscriptionFee): any {
    switch (value.type) {
      case "RATE":
        return {
          ...RateFeeSerializer.serialize(value),
          type: "RATE",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeSerializer.serialize(value),
          type: "ONE_TIME",
        };
      case "RECURRING":
        return {
          ...RecurringFeeSerializer.serialize(value),
          type: "RECURRING",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeSerializer.serialize(value),
          type: "CAPACITY",
        };
      case "SLOT":
        return {
          ...SlotFeeSerializer.serialize(value),
          type: "SLOT",
        };
      case "USAGE":
        return {
          ...UsageFeeSerializer.serialize(value),
          type: "USAGE",
        };
      default:
        return value;
    }
  },
};
