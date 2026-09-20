// this file is @generated
import {
  type BillingMetricAggregateEnum,
  BillingMetricAggregateEnumSerializer,
} from "./billingMetricAggregateEnum";
import { type MetricFilter, MetricFilterSerializer } from "./metricFilter";
import {
  type MetricSegmentationMatrix,
  MetricSegmentationMatrixSerializer,
} from "./metricSegmentationMatrix";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";
import { type ProductId, ProductIdSerializer } from "./productId";
import { type UnitConversion, UnitConversionSerializer } from "./unitConversion";

export interface CreateMetricRequest {
  aggregationKey?: string | null;

  aggregationType: BillingMetricAggregateEnum;

  code: string;

  description?: string | null;

  /** Pre-aggregation property filters. Optional and backward-compatible; omit for none. */
  filters?: MetricFilter[] | null;

  name: string;

  productFamilyId: ProductFamilyId;

  productId?: ProductId | null;

  segmentationMatrix?: MetricSegmentationMatrix | null;

  unitConversion?: UnitConversion | null;

  usageGroupKey?: string | null;
}

export const CreateMetricRequestSerializer = {
  _fromJsonObject(object: any): CreateMetricRequest {
    return {
      aggregationKey: object["aggregation_key"],
      aggregationType: BillingMetricAggregateEnumSerializer._fromJsonObject(
        object["aggregation_type"]
      ),
      code: object["code"],
      description: object["description"],
      filters:
        object["filters"] != null
          ? object["filters"].map((item: any) =>
              MetricFilterSerializer._fromJsonObject(item)
            )
          : undefined,
      name: object["name"],
      productFamilyId: ProductFamilyIdSerializer._fromJsonObject(
        object["product_family_id"]
      ),
      productId:
        object["product_id"] != null
          ? ProductIdSerializer._fromJsonObject(object["product_id"])
          : undefined,
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
      usageGroupKey: object["usage_group_key"],
    };
  },

  _toJsonObject(self: CreateMetricRequest): any {
    return {
      aggregation_key: self.aggregationKey,
      aggregation_type: BillingMetricAggregateEnumSerializer._toJsonObject(
        self.aggregationType
      ),
      code: self.code,
      description: self.description,
      filters:
        self.filters != null
          ? self.filters.map((item: any) => MetricFilterSerializer._toJsonObject(item))
          : undefined,
      name: self.name,
      product_family_id: ProductFamilyIdSerializer._toJsonObject(self.productFamilyId),
      product_id:
        self.productId != null
          ? ProductIdSerializer._toJsonObject(self.productId)
          : undefined,
      segmentation_matrix:
        self.segmentationMatrix != null
          ? MetricSegmentationMatrixSerializer._toJsonObject(self.segmentationMatrix)
          : undefined,
      unit_conversion:
        self.unitConversion != null
          ? UnitConversionSerializer._toJsonObject(self.unitConversion)
          : undefined,
      usage_group_key: self.usageGroupKey,
    };
  },
};
