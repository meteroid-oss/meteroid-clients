// this file is @generated
import { extraProperties } from "../json.js";
import {
  type BillingPeriodEnum,
  BillingPeriodEnumSerializer,
} from "./billingPeriodEnum.js";

export interface AvailableParameters {
  /** Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL") */
  billingPeriods?: { [key: string]: BillingPeriodEnum[] } | undefined;
  /** Map of component_id -> available capacity values */
  capacityThresholds?: { [key: string]: number[] } | undefined;
  /** List of component_ids that support slot parametrization (initial slot count) */
  slotComponents?: string[] | undefined;
}

/** Converts `AvailableParameters` values from (`parse`) and to (`serialize`) their JSON form. */
export const AvailableParametersSerializer = {
  parse(json: any): AvailableParameters {
    return {
      ...extraProperties(json, [
        "billing_periods",
        "capacity_thresholds",
        "slot_components",
      ]),
      billingPeriods:
        json["billing_periods"] != null
          ? Object.fromEntries(
              Object.entries(json["billing_periods"]).map(
                ([key, entry]: [string, any]) => [
                  key,
                  entry.map((item: any) => BillingPeriodEnumSerializer.parse(item)),
                ]
              )
            )
          : undefined,
      capacityThresholds: json["capacity_thresholds"],
      slotComponents: json["slot_components"],
    };
  },

  serialize(value: AvailableParameters): any {
    return {
      ...extraProperties(value, [
        "billingPeriods",
        "capacityThresholds",
        "slotComponents",
      ]),
      billing_periods:
        value.billingPeriods != null
          ? Object.fromEntries(
              Object.entries(value.billingPeriods).map(([key, entry]) => [
                key,
                entry.map((item: any) => BillingPeriodEnumSerializer.serialize(item)),
              ])
            )
          : undefined,
      capacity_thresholds: value.capacityThresholds,
      slot_components: value.slotComponents,
    };
  },
};
