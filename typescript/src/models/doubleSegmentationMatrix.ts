// this file is @generated
import { type MetricDimension, MetricDimensionSerializer } from "./metricDimension";

export interface DoubleSegmentationMatrix {
  dimension1: MetricDimension;

  dimension2: MetricDimension;
}

export const DoubleSegmentationMatrixSerializer = {
  _fromJsonObject(object: any): DoubleSegmentationMatrix {
    return {
      dimension1: MetricDimensionSerializer._fromJsonObject(object["dimension1"]),
      dimension2: MetricDimensionSerializer._fromJsonObject(object["dimension2"]),
    };
  },

  _toJsonObject(self: DoubleSegmentationMatrix): any {
    return {
      dimension1: MetricDimensionSerializer._toJsonObject(self.dimension1),
      dimension2: MetricDimensionSerializer._toJsonObject(self.dimension2),
    };
  },
};
