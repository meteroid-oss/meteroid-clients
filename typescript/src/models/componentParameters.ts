// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";

export interface ComponentParameters {
  billingPeriod?: BillingPeriodEnum | null;

  committedCapacity?: number | null;

  initialSlotCount?: number | null;
}

export const ComponentParametersSerializer = {
  _fromJsonObject(object: any): ComponentParameters {
    return {
      billingPeriod:
        object["billing_period"] != null
          ? BillingPeriodEnumSerializer._fromJsonObject(object["billing_period"])
          : undefined,
      committedCapacity: object["committed_capacity"],
      initialSlotCount: object["initial_slot_count"],
    };
  },

  _toJsonObject(self: ComponentParameters): any {
    return {
      billing_period:
        self.billingPeriod != null
          ? BillingPeriodEnumSerializer._toJsonObject(self.billingPeriod)
          : undefined,
      committed_capacity: self.committedCapacity,
      initial_slot_count: self.initialSlotCount,
    };
  },
};
