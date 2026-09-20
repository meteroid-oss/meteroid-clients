// this file is @generated
import { type CapacityPlanFee, CapacityPlanFeeSerializer } from "./capacityPlanFee";
import {
  type ExtraRecurringPlanFee,
  ExtraRecurringPlanFeeSerializer,
} from "./extraRecurringPlanFee";
import { type OneTimePlanFee, OneTimePlanFeeSerializer } from "./oneTimePlanFee";
import { type RatePlanFee, RatePlanFeeSerializer } from "./ratePlanFee";
import { type SlotPlanFee, SlotPlanFeeSerializer } from "./slotPlanFee";
import { type UsagePlanFee, UsagePlanFeeSerializer } from "./usagePlanFee";

export interface FeeRate extends RatePlanFee {
  type: "RATE";
}
export interface FeeSlot extends SlotPlanFee {
  type: "SLOT";
}
export interface FeeCapacity extends CapacityPlanFee {
  type: "CAPACITY";
}
export interface FeeUsage extends UsagePlanFee {
  type: "USAGE";
}
export interface FeeExtraRecurring extends ExtraRecurringPlanFee {
  type: "EXTRA_RECURRING";
}
export interface FeeOneTime extends OneTimePlanFee {
  type: "ONE_TIME";
}

export type Fee =
  | FeeRate
  | FeeSlot
  | FeeCapacity
  | FeeUsage
  | FeeExtraRecurring
  | FeeOneTime;

export const FeeSerializer = {
  _fromJsonObject(object: any): Fee {
    const type = object["type"];

    switch (type) {
      case "RATE":
        return {
          ...RatePlanFeeSerializer._fromJsonObject(object),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPlanFeeSerializer._fromJsonObject(object),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPlanFeeSerializer._fromJsonObject(object),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePlanFeeSerializer._fromJsonObject(object),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPlanFeeSerializer._fromJsonObject(object),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePlanFeeSerializer._fromJsonObject(object),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for Fee: ${type}`);
    }
  },

  _toJsonObject(self: Fee): any {
    switch (self.type) {
      case "RATE":
        return {
          ...RatePlanFeeSerializer._toJsonObject(self),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotPlanFeeSerializer._toJsonObject(self),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityPlanFeeSerializer._toJsonObject(self),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsagePlanFeeSerializer._toJsonObject(self),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringPlanFeeSerializer._toJsonObject(self),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimePlanFeeSerializer._toJsonObject(self),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for Fee`);
    }
  },
};
