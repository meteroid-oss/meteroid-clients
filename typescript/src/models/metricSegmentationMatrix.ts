// this file is @generated
import {
  type DoubleSegmentationMatrix,
  DoubleSegmentationMatrixSerializer,
} from "./doubleSegmentationMatrix.js";
import {
  type LinkedSegmentationMatrix,
  LinkedSegmentationMatrixSerializer,
} from "./linkedSegmentationMatrix.js";
import { type MetricDimension, MetricDimensionSerializer } from "./metricDimension.js";

export interface MetricSegmentationMatrixSingle extends MetricDimension {
  type: "SINGLE";
}
export interface MetricSegmentationMatrixDouble extends DoubleSegmentationMatrix {
  type: "DOUBLE";
}
export interface MetricSegmentationMatrixLinked extends LinkedSegmentationMatrix {
  type: "LINKED";
}

export type MetricSegmentationMatrix =
  | MetricSegmentationMatrixSingle
  | MetricSegmentationMatrixDouble
  | MetricSegmentationMatrixLinked;

/** Converts `MetricSegmentationMatrix` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricSegmentationMatrixSerializer = {
  parse(json: any): MetricSegmentationMatrix {
    switch (json["type"]) {
      case "SINGLE":
        return {
          ...MetricDimensionSerializer.parse(json),
          type: "SINGLE",
        };
      case "DOUBLE":
        return {
          ...DoubleSegmentationMatrixSerializer.parse(json),
          type: "DOUBLE",
        };
      case "LINKED":
        return {
          ...LinkedSegmentationMatrixSerializer.parse(json),
          type: "LINKED",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: MetricSegmentationMatrix): any {
    switch (value.type) {
      case "SINGLE":
        return {
          ...MetricDimensionSerializer.serialize(value),
          type: "SINGLE",
        };
      case "DOUBLE":
        return {
          ...DoubleSegmentationMatrixSerializer.serialize(value),
          type: "DOUBLE",
        };
      case "LINKED":
        return {
          ...LinkedSegmentationMatrixSerializer.serialize(value),
          type: "LINKED",
        };
      default:
        return value;
    }
  },
};
