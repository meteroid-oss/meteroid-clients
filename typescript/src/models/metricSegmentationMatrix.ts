// this file is @generated
import {
  type DoubleSegmentationMatrix,
  DoubleSegmentationMatrixSerializer,
} from "./doubleSegmentationMatrix";
import {
  type LinkedSegmentationMatrix,
  LinkedSegmentationMatrixSerializer,
} from "./linkedSegmentationMatrix";
import { type MetricDimension, MetricDimensionSerializer } from "./metricDimension";

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

export const MetricSegmentationMatrixSerializer = {
  _fromJsonObject(object: any): MetricSegmentationMatrix {
    const type = object["type"];

    switch (type) {
      case "SINGLE":
        return {
          ...MetricDimensionSerializer._fromJsonObject(object),
          type: "SINGLE",
        };
      case "DOUBLE":
        return {
          ...DoubleSegmentationMatrixSerializer._fromJsonObject(object),
          type: "DOUBLE",
        };
      case "LINKED":
        return {
          ...LinkedSegmentationMatrixSerializer._fromJsonObject(object),
          type: "LINKED",
        };
      default:
        throw new Error(`Unexpected type for MetricSegmentationMatrix: ${type}`);
    }
  },

  _toJsonObject(self: MetricSegmentationMatrix): any {
    switch (self.type) {
      case "SINGLE":
        return {
          ...MetricDimensionSerializer._toJsonObject(self),
          type: "SINGLE",
        };
      case "DOUBLE":
        return {
          ...DoubleSegmentationMatrixSerializer._toJsonObject(self),
          type: "DOUBLE",
        };
      case "LINKED":
        return {
          ...LinkedSegmentationMatrixSerializer._toJsonObject(self),
          type: "LINKED",
        };
      default:
        throw new Error(`Unexpected type for MetricSegmentationMatrix`);
    }
  },
};
