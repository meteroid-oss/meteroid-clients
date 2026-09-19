// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type ResetPeriod, ResetPeriodSerializer } from "./resetPeriod";

export interface MeteredResolvedEntitlementValue {
  enabled: boolean;

  limit?: string | null;

  metricId: BillableMetricId;

  resetPeriod: ResetPeriod;
}

export const MeteredResolvedEntitlementValueSerializer = {
  _fromJsonObject(object: any): MeteredResolvedEntitlementValue {
    return {
      enabled: object["enabled"],
      limit: object["limit"],
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      resetPeriod: ResetPeriodSerializer._fromJsonObject(object["reset_period"]),
    };
  },

  _toJsonObject(self: MeteredResolvedEntitlementValue): any {
    return {
      enabled: self.enabled,
      limit: self.limit,
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      reset_period: ResetPeriodSerializer._toJsonObject(self.resetPeriod),
    };
  },
};
