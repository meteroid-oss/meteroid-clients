// this file is @generated
import {
  type MetricFilterOperator,
  MetricFilterOperatorSerializer,
} from "./metricFilterOperator";
/**
 * A pre-aggregation filter: only events whose `property` matches feed the metric's
 * aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple
 * filters are ANDed.
 */
export interface MetricFilter {
  op: MetricFilterOperator;

  property: string;

  values: string[];
}

export const MetricFilterSerializer = {
  _fromJsonObject(object: any): MetricFilter {
    return {
      op: MetricFilterOperatorSerializer._fromJsonObject(object["op"]),
      property: object["property"],
      values: object["values"],
    };
  },

  _toJsonObject(self: MetricFilter): any {
    return {
      op: MetricFilterOperatorSerializer._toJsonObject(self.op),
      property: self.property,
      values: self.values,
    };
  },
};
