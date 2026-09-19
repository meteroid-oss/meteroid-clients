// this file is @generated
import {
  type CapacityFeeStructure,
  CapacityFeeStructureSerializer,
} from "./capacityFeeStructure";
import {
  type ExtraRecurringFeeStructure,
  ExtraRecurringFeeStructureSerializer,
} from "./extraRecurringFeeStructure";
import {
  type OneTimeFeeStructure,
  OneTimeFeeStructureSerializer,
} from "./oneTimeFeeStructure";
import { type RateFeeStructure, RateFeeStructureSerializer } from "./rateFeeStructure";
import { type SlotFeeStructure, SlotFeeStructureSerializer } from "./slotFeeStructure";
import { type UsageFeeStructure, UsageFeeStructureSerializer } from "./usageFeeStructure";

export interface ProductFeeStructureRate extends RateFeeStructure {
  type: "RATE";
}
export interface ProductFeeStructureSlot extends SlotFeeStructure {
  type: "SLOT";
}
export interface ProductFeeStructureCapacity extends CapacityFeeStructure {
  type: "CAPACITY";
}
export interface ProductFeeStructureUsage extends UsageFeeStructure {
  type: "USAGE";
}
export interface ProductFeeStructureExtraRecurring extends ExtraRecurringFeeStructure {
  type: "EXTRA_RECURRING";
}
export interface ProductFeeStructureOneTime extends OneTimeFeeStructure {
  type: "ONE_TIME";
}

export type ProductFeeStructure =
  | ProductFeeStructureRate
  | ProductFeeStructureSlot
  | ProductFeeStructureCapacity
  | ProductFeeStructureUsage
  | ProductFeeStructureExtraRecurring
  | ProductFeeStructureOneTime;

export const ProductFeeStructureSerializer = {
  _fromJsonObject(object: any): ProductFeeStructure {
    const type = object["type"];

    switch (type) {
      case "RATE":
        return {
          ...RateFeeStructureSerializer._fromJsonObject(object),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotFeeStructureSerializer._fromJsonObject(object),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeStructureSerializer._fromJsonObject(object),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsageFeeStructureSerializer._fromJsonObject(object),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringFeeStructureSerializer._fromJsonObject(object),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeStructureSerializer._fromJsonObject(object),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for ProductFeeStructure: ${type}`);
    }
  },

  _toJsonObject(self: ProductFeeStructure): any {
    switch (self.type) {
      case "RATE":
        return {
          ...RateFeeStructureSerializer._toJsonObject(self),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotFeeStructureSerializer._toJsonObject(self),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeStructureSerializer._toJsonObject(self),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsageFeeStructureSerializer._toJsonObject(self),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringFeeStructureSerializer._toJsonObject(self),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeStructureSerializer._toJsonObject(self),
          type: "ONE_TIME",
        };
      default:
        throw new Error(`Unexpected type for ProductFeeStructure`);
    }
  },
};
