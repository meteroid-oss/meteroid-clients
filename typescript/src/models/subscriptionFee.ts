// this file is @generated
import { type CapacityFee, CapacityFeeSerializer } from "./capacityFee";
import { type OneTimeFee, OneTimeFeeSerializer } from "./oneTimeFee";
import { type RateFee, RateFeeSerializer } from "./rateFee";
import { type RecurringFee, RecurringFeeSerializer } from "./recurringFee";
import { type SlotFee, SlotFeeSerializer } from "./slotFee";
import { type UsageFee, UsageFeeSerializer } from "./usageFee";

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

export const SubscriptionFeeSerializer = {
  _fromJsonObject(object: any): SubscriptionFee {
    const type = object["type"];

    switch (type) {
      case "RATE":
        return {
          ...RateFeeSerializer._fromJsonObject(object),
          type: "RATE",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeSerializer._fromJsonObject(object),
          type: "ONE_TIME",
        };
      case "RECURRING":
        return {
          ...RecurringFeeSerializer._fromJsonObject(object),
          type: "RECURRING",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeSerializer._fromJsonObject(object),
          type: "CAPACITY",
        };
      case "SLOT":
        return {
          ...SlotFeeSerializer._fromJsonObject(object),
          type: "SLOT",
        };
      case "USAGE":
        return {
          ...UsageFeeSerializer._fromJsonObject(object),
          type: "USAGE",
        };
      default:
        throw new Error(`Unexpected type for SubscriptionFee: ${type}`);
    }
  },

  _toJsonObject(self: SubscriptionFee): any {
    switch (self.type) {
      case "RATE":
        return {
          ...RateFeeSerializer._toJsonObject(self),
          type: "RATE",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeSerializer._toJsonObject(self),
          type: "ONE_TIME",
        };
      case "RECURRING":
        return {
          ...RecurringFeeSerializer._toJsonObject(self),
          type: "RECURRING",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeSerializer._toJsonObject(self),
          type: "CAPACITY",
        };
      case "SLOT":
        return {
          ...SlotFeeSerializer._toJsonObject(self),
          type: "SLOT",
        };
      case "USAGE":
        return {
          ...UsageFeeSerializer._toJsonObject(self),
          type: "USAGE",
        };
      default:
        throw new Error(`Unexpected type for SubscriptionFee`);
    }
  },
};
