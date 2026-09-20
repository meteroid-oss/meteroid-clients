// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type UsageModelEnum, UsageModelEnumSerializer } from "./usageModelEnum";

export interface UsageFeeStructure {
  metricId: BillableMetricId;

  model: UsageModelEnum;
}

export const UsageFeeStructureSerializer = {
  _fromJsonObject(object: any): UsageFeeStructure {
    return {
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      model: UsageModelEnumSerializer._fromJsonObject(object["model"]),
    };
  },

  _toJsonObject(self: UsageFeeStructure): any {
    return {
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      model: UsageModelEnumSerializer._toJsonObject(self.model),
    };
  },
};
