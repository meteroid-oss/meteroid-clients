// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";

export interface MeteredFeatureType {
  metricId: BillableMetricId;
}

export const MeteredFeatureTypeSerializer = {
  _fromJsonObject(object: any): MeteredFeatureType {
    return {
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
    };
  },

  _toJsonObject(self: MeteredFeatureType): any {
    return {
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
    };
  },
};
