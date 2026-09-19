// this file is @generated
import { type MetricFilter, MetricFilterSerializer } from "./metricFilter";
import {
  type MetricSegmentationMatrix,
  MetricSegmentationMatrixSerializer,
} from "./metricSegmentationMatrix";
import { type UnitConversion, UnitConversionSerializer } from "./unitConversion";

export interface UpdateMetricRequest {
  description?: string | null;

  /** Absent = leave filters untouched; present (even empty) = replace them. */
  filters?: MetricFilter[] | null;

  name?: string | null;

  segmentationMatrix?: MetricSegmentationMatrix | null;

  unitConversion?: UnitConversion | null;
}

export const UpdateMetricRequestSerializer = {
  _fromJsonObject(object: any): UpdateMetricRequest {
    return {
      description: object["description"],
      filters:
        object["filters"] != null
          ? object["filters"].map((item: any) =>
              MetricFilterSerializer._fromJsonObject(item)
            )
          : undefined,
      name: object["name"],
      segmentationMatrix:
        object["segmentation_matrix"] != null
          ? MetricSegmentationMatrixSerializer._fromJsonObject(
              object["segmentation_matrix"]
            )
          : undefined,
      unitConversion:
        object["unit_conversion"] != null
          ? UnitConversionSerializer._fromJsonObject(object["unit_conversion"])
          : undefined,
    };
  },

  _toJsonObject(self: UpdateMetricRequest): any {
    return {
      description: self.description,
      filters:
        self.filters != null
          ? self.filters.map((item: any) => MetricFilterSerializer._toJsonObject(item))
          : undefined,
      name: self.name,
      segmentation_matrix:
        self.segmentationMatrix != null
          ? MetricSegmentationMatrixSerializer._toJsonObject(self.segmentationMatrix)
          : undefined,
      unit_conversion:
        self.unitConversion != null
          ? UnitConversionSerializer._toJsonObject(self.unitConversion)
          : undefined,
    };
  },
};
