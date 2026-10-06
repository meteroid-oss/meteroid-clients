// this file is @generated
import { extraProperties } from "../json.js";
import {
  type BillingPeriodEnum,
  BillingPeriodEnumSerializer,
} from "./billingPeriodEnum.js";

export interface SubscriptionAddOnParameterization {
  billingPeriod?: BillingPeriodEnum | null | undefined;
  committedCapacity?: number | null | undefined;
  initialSlotCount?: number | null | undefined;
}

/** Converts `SubscriptionAddOnParameterization` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionAddOnParameterizationSerializer = {
  parse(json: any): SubscriptionAddOnParameterization {
    return {
      ...extraProperties(json, [
        "billing_period",
        "committed_capacity",
        "initial_slot_count",
      ]),
      billingPeriod:
        json["billing_period"] != null
          ? BillingPeriodEnumSerializer.parse(json["billing_period"])
          : json["billing_period"],
      committedCapacity: json["committed_capacity"],
      initialSlotCount: json["initial_slot_count"],
    };
  },

  serialize(value: SubscriptionAddOnParameterization): any {
    return {
      ...extraProperties(value, [
        "billingPeriod",
        "committedCapacity",
        "initialSlotCount",
      ]),
      billing_period:
        value.billingPeriod != null
          ? BillingPeriodEnumSerializer.serialize(value.billingPeriod)
          : value.billingPeriod,
      committed_capacity: value.committedCapacity,
      initial_slot_count: value.initialSlotCount,
    };
  },
};
