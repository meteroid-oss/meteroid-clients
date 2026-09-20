// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";

export interface CapacityFee {
  included: number;

  metricId: BillableMetricId;

  overageRate: string;

  rate: string;
}

export const CapacityFeeSerializer = {
  _fromJsonObject(object: any): CapacityFee {
    return {
      included: object["included"],
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      overageRate: object["overage_rate"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: CapacityFee): any {
    return {
      included: self.included,
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      overage_rate: self.overageRate,
      rate: self.rate,
    };
  },
};
