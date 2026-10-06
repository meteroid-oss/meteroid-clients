// this file is @generated
import { extraProperties } from "../json.js";
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId.js";

export interface MeteredFeatureType {
  metricId: BillableMetricId;
}

/** Converts `MeteredFeatureType` values from (`parse`) and to (`serialize`) their JSON form. */
export const MeteredFeatureTypeSerializer = {
  parse(json: any): MeteredFeatureType {
    return {
      ...extraProperties(json, ["metric_id"]),
      metricId: BillableMetricIdSerializer.parse(json["metric_id"]),
    };
  },

  serialize(value: MeteredFeatureType): any {
    return {
      ...extraProperties(value, ["metricId"]),
      metric_id: BillableMetricIdSerializer.serialize(value.metricId),
    };
  },
};
