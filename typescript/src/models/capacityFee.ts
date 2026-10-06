// this file is @generated
import { extraProperties } from "../json.js";
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId.js";

export interface CapacityFee {
  included: number;
  metricId: BillableMetricId;
  overageRate: string;
  rate: string;
}

/** Converts `CapacityFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const CapacityFeeSerializer = {
  parse(json: any): CapacityFee {
    return {
      ...extraProperties(json, ["included", "metric_id", "overage_rate", "rate"]),
      included: json["included"],
      metricId: BillableMetricIdSerializer.parse(json["metric_id"]),
      overageRate: json["overage_rate"],
      rate: json["rate"],
    };
  },

  serialize(value: CapacityFee): any {
    return {
      ...extraProperties(value, ["included", "metricId", "overageRate", "rate"]),
      included: value.included,
      metric_id: BillableMetricIdSerializer.serialize(value.metricId),
      overage_rate: value.overageRate,
      rate: value.rate,
    };
  },
};
