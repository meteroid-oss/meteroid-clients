// this file is @generated
import {
  type CapacityFeeStructure,
  CapacityFeeStructureSerializer,
} from "./capacityFeeStructure.js";
import {
  type ExtraRecurringFeeStructure,
  ExtraRecurringFeeStructureSerializer,
} from "./extraRecurringFeeStructure.js";
import {
  type OneTimeFeeStructure,
  OneTimeFeeStructureSerializer,
} from "./oneTimeFeeStructure.js";
import { type RateFeeStructure, RateFeeStructureSerializer } from "./rateFeeStructure.js";
import { type SlotFeeStructure, SlotFeeStructureSerializer } from "./slotFeeStructure.js";
import {
  type UsageFeeStructure,
  UsageFeeStructureSerializer,
} from "./usageFeeStructure.js";

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

/** Converts `ProductFeeStructure` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductFeeStructureSerializer = {
  parse(json: any): ProductFeeStructure {
    switch (json["type"]) {
      case "RATE":
        return {
          ...RateFeeStructureSerializer.parse(json),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotFeeStructureSerializer.parse(json),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeStructureSerializer.parse(json),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsageFeeStructureSerializer.parse(json),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringFeeStructureSerializer.parse(json),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeStructureSerializer.parse(json),
          type: "ONE_TIME",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: ProductFeeStructure): any {
    switch (value.type) {
      case "RATE":
        return {
          ...RateFeeStructureSerializer.serialize(value),
          type: "RATE",
        };
      case "SLOT":
        return {
          ...SlotFeeStructureSerializer.serialize(value),
          type: "SLOT",
        };
      case "CAPACITY":
        return {
          ...CapacityFeeStructureSerializer.serialize(value),
          type: "CAPACITY",
        };
      case "USAGE":
        return {
          ...UsageFeeStructureSerializer.serialize(value),
          type: "USAGE",
        };
      case "EXTRA_RECURRING":
        return {
          ...ExtraRecurringFeeStructureSerializer.serialize(value),
          type: "EXTRA_RECURRING",
        };
      case "ONE_TIME":
        return {
          ...OneTimeFeeStructureSerializer.serialize(value),
          type: "ONE_TIME",
        };
      default:
        return value;
    }
  },
};
