// this file is @generated
import { extraProperties } from "../json.js";
import { type MetricDimension, MetricDimensionSerializer } from "./metricDimension.js";

export interface DoubleSegmentationMatrix {
  dimension1: MetricDimension;
  dimension2: MetricDimension;
}

/** Converts `DoubleSegmentationMatrix` values from (`parse`) and to (`serialize`) their JSON form. */
export const DoubleSegmentationMatrixSerializer = {
  parse(json: any): DoubleSegmentationMatrix {
    return {
      ...extraProperties(json, ["dimension1", "dimension2"]),
      dimension1: MetricDimensionSerializer.parse(json["dimension1"]),
      dimension2: MetricDimensionSerializer.parse(json["dimension2"]),
    };
  },

  serialize(value: DoubleSegmentationMatrix): any {
    return {
      ...extraProperties(value, ["dimension1", "dimension2"]),
      dimension1: MetricDimensionSerializer.serialize(value.dimension1),
      dimension2: MetricDimensionSerializer.serialize(value.dimension2),
    };
  },
};
