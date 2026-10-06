// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId.js";
import {
  type BillingMetricAggregateEnum,
  BillingMetricAggregateEnumSerializer,
} from "./billingMetricAggregateEnum.js";
import {
  type MetricSegmentationMatrix,
  MetricSegmentationMatrixSerializer,
} from "./metricSegmentationMatrix.js";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";
import {
  type UnitConversionRoundingEnum,
  UnitConversionRoundingEnumSerializer,
} from "./unitConversionRoundingEnum.js";

export interface MetricEventData {
  aggregationKey?: string | null | undefined;
  aggregationType: BillingMetricAggregateEnum;
  code: string;
  createdAt: Date;
  description?: string | null | undefined;
  metricId: BillableMetricId;
  name: string;
  productFamilyId: ProductFamilyId;
  productId?: ProductId | null | undefined;
  segmentationMatrix?: MetricSegmentationMatrix | null | undefined;
  unitConversionFactor?: number | null | undefined;
  unitConversionRounding?: UnitConversionRoundingEnum | null | undefined;
  usageGroupKey?: string | null | undefined;
}

/** Converts `MetricEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricEventDataSerializer = {
  parse(json: any): MetricEventData {
    return {
      ...extraProperties(json, [
        "aggregation_key",
        "aggregation_type",
        "code",
        "created_at",
        "description",
        "metric_id",
        "name",
        "product_family_id",
        "product_id",
        "segmentation_matrix",
        "unit_conversion_factor",
        "unit_conversion_rounding",
        "usage_group_key",
      ]),
      aggregationKey: json["aggregation_key"],
      aggregationType: BillingMetricAggregateEnumSerializer.parse(
        json["aggregation_type"]
      ),
      code: json["code"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      metricId: BillableMetricIdSerializer.parse(json["metric_id"]),
      name: json["name"],
      productFamilyId: ProductFamilyIdSerializer.parse(json["product_family_id"]),
      productId:
        json["product_id"] != null
          ? ProductIdSerializer.parse(json["product_id"])
          : json["product_id"],
      segmentationMatrix:
        json["segmentation_matrix"] != null
          ? MetricSegmentationMatrixSerializer.parse(json["segmentation_matrix"])
          : json["segmentation_matrix"],
      unitConversionFactor: json["unit_conversion_factor"],
      unitConversionRounding:
        json["unit_conversion_rounding"] != null
          ? UnitConversionRoundingEnumSerializer.parse(json["unit_conversion_rounding"])
          : json["unit_conversion_rounding"],
      usageGroupKey: json["usage_group_key"],
    };
  },

  serialize(value: MetricEventData): any {
    return {
      ...extraProperties(value, [
        "aggregationKey",
        "aggregationType",
        "code",
        "createdAt",
        "description",
        "metricId",
        "name",
        "productFamilyId",
        "productId",
        "segmentationMatrix",
        "unitConversionFactor",
        "unitConversionRounding",
        "usageGroupKey",
      ]),
      aggregation_key: value.aggregationKey,
      aggregation_type: BillingMetricAggregateEnumSerializer.serialize(
        value.aggregationType
      ),
      code: value.code,
      created_at: value.createdAt,
      description: value.description,
      metric_id: BillableMetricIdSerializer.serialize(value.metricId),
      name: value.name,
      product_family_id: ProductFamilyIdSerializer.serialize(value.productFamilyId),
      product_id:
        value.productId != null
          ? ProductIdSerializer.serialize(value.productId)
          : value.productId,
      segmentation_matrix:
        value.segmentationMatrix != null
          ? MetricSegmentationMatrixSerializer.serialize(value.segmentationMatrix)
          : value.segmentationMatrix,
      unit_conversion_factor: value.unitConversionFactor,
      unit_conversion_rounding:
        value.unitConversionRounding != null
          ? UnitConversionRoundingEnumSerializer.serialize(value.unitConversionRounding)
          : value.unitConversionRounding,
      usage_group_key: value.usageGroupKey,
    };
  },
};
