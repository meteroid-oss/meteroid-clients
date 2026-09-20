// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";

export interface AvailableParameters {
  /** Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL") */
  billingPeriods?: { [key: string]: BillingPeriodEnum[] };

  /** Map of component_id -> available capacity values */
  capacityThresholds?: { [key: string]: number[] };

  /** List of component_ids that support slot parametrization (initial slot count) */
  slotComponents?: string[];
}

export const AvailableParametersSerializer = {
  _fromJsonObject(object: any): AvailableParameters {
    return {
      billingPeriods:
        object["billing_periods"] != null
          ? Object.fromEntries(
              Object.entries(object["billing_periods"]).map((entry: [string, any]) => [
                entry[0],
                entry[1].map((item: any) =>
                  BillingPeriodEnumSerializer._fromJsonObject(item)
                ),
              ])
            )
          : undefined,
      capacityThresholds:
        object["capacity_thresholds"] != null
          ? Object.fromEntries(
              Object.entries(object["capacity_thresholds"]).map(
                (entry: [string, any]) => [entry[0], entry[1]]
              )
            )
          : undefined,
      slotComponents: object["slot_components"],
    };
  },

  _toJsonObject(self: AvailableParameters): any {
    return {
      billing_periods:
        self.billingPeriods != null
          ? Object.fromEntries(
              Object.entries(self.billingPeriods).map((entry: [string, any]) => [
                entry[0],
                entry[1].map((item: any) =>
                  BillingPeriodEnumSerializer._toJsonObject(item)
                ),
              ])
            )
          : undefined,
      capacity_thresholds:
        self.capacityThresholds != null
          ? Object.fromEntries(
              Object.entries(self.capacityThresholds).map((entry: [string, any]) => [
                entry[0],
                entry[1],
              ])
            )
          : undefined,
      slot_components: self.slotComponents,
    };
  },
};
