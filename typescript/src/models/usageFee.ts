// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type UsagePricingModel, UsagePricingModelSerializer } from "./usagePricingModel";

export interface UsageFee {
  metricId: BillableMetricId;

  model: UsagePricingModel;
}

export const UsageFeeSerializer = {
  _fromJsonObject(object: any): UsageFee {
    return {
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      model: UsagePricingModelSerializer._fromJsonObject(object["model"]),
    };
  },

  _toJsonObject(self: UsageFee): any {
    return {
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      model: UsagePricingModelSerializer._toJsonObject(self.model),
    };
  },
};
