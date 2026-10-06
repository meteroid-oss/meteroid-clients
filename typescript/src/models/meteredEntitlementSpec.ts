// this file is @generated
import { extraProperties } from "../json.js";
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId.js";
import { type ResetPeriod, ResetPeriodSerializer } from "./resetPeriod.js";

export interface MeteredEntitlementSpec {
  enabled: boolean;
  limit?: string | null | undefined;
  metricId: BillableMetricId;
  resetPeriod: ResetPeriod;
}

/** Converts `MeteredEntitlementSpec` values from (`parse`) and to (`serialize`) their JSON form. */
export const MeteredEntitlementSpecSerializer = {
  parse(json: any): MeteredEntitlementSpec {
    return {
      ...extraProperties(json, ["enabled", "limit", "metric_id", "reset_period"]),
      enabled: json["enabled"],
      limit: json["limit"],
      metricId: BillableMetricIdSerializer.parse(json["metric_id"]),
      resetPeriod: ResetPeriodSerializer.parse(json["reset_period"]),
    };
  },

  serialize(value: MeteredEntitlementSpec): any {
    return {
      ...extraProperties(value, ["enabled", "limit", "metricId", "resetPeriod"]),
      enabled: value.enabled,
      limit: value.limit,
      metric_id: BillableMetricIdSerializer.serialize(value.metricId),
      reset_period: ResetPeriodSerializer.serialize(value.resetPeriod),
    };
  },
};
