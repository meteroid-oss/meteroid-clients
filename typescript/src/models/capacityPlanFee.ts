// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type CapacityThreshold, CapacityThresholdSerializer } from "./capacityThreshold";
/** Capacity-based fee with included committed usage and overage */
export interface CapacityPlanFee {
  cadence: BillingPeriodEnum;

  metricId: BillableMetricId;

  thresholds: CapacityThreshold[];
}

export const CapacityPlanFeeSerializer = {
  _fromJsonObject(object: any): CapacityPlanFee {
    return {
      cadence: BillingPeriodEnumSerializer._fromJsonObject(object["cadence"]),
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      thresholds: object["thresholds"].map((item: any) =>
        CapacityThresholdSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: CapacityPlanFee): any {
    return {
      cadence: BillingPeriodEnumSerializer._toJsonObject(self.cadence),
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      thresholds: self.thresholds.map((item: any) =>
        CapacityThresholdSerializer._toJsonObject(item)
      ),
    };
  },
};
