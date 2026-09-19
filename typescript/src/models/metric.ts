// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
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

export interface Metric {
  aggregationKey?: string | null;

  aggregationType: BillingMetricAggregateEnum;

  archivedAt?: Date | null;

  code: string;

  createdAt: Date;

  description?: string | null;

  filters?: MetricFilter[];

  id: BillableMetricId;

  name: string;

  productFamilyId: ProductFamilyId;

  productId?: ProductId | null;

  segmentationMatrix?: MetricSegmentationMatrix | null;

  unitConversion?: UnitConversion | null;

  usageGroupKey?: string | null;
}

export const MetricSerializer = {
  _fromJsonObject(object: any): Metric {
    return {
      aggregationKey: object["aggregation_key"],
      aggregationType: BillingMetricAggregateEnumSerializer._fromJsonObject(
        object["aggregation_type"]
      ),
      archivedAt:
        object["archived_at"] != null ? new Date(object["archived_at"]) : undefined,
      code: object["code"],
      createdAt: new Date(object["created_at"]),
      description: object["description"],
      filters:
        object["filters"] != null
          ? object["filters"].map((item: any) =>
              MetricFilterSerializer._fromJsonObject(item)
            )
          : undefined,
      id: BillableMetricIdSerializer._fromJsonObject(object["id"]),
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

  _toJsonObject(self: Metric): any {
    return {
      aggregation_key: self.aggregationKey,
      aggregation_type: BillingMetricAggregateEnumSerializer._toJsonObject(
        self.aggregationType
      ),
      archived_at: self.archivedAt,
      code: self.code,
      created_at: self.createdAt,
      description: self.description,
      filters:
        self.filters != null
          ? self.filters.map((item: any) => MetricFilterSerializer._toJsonObject(item))
          : undefined,
      id: BillableMetricIdSerializer._toJsonObject(self.id),
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
