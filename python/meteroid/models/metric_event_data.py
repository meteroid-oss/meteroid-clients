# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
from .metric_segmentation_matrix import MetricSegmentationMatrix
from .product_family_id import ProductFamilyId
from .product_id import ProductId
from .unit_conversion_rounding_enum import UnitConversionRoundingEnum


@dataclasses.dataclass
class MetricEventData(BaseModel):
    aggregation_type: BillingMetricAggregateEnum

    code: str

    created_at: datetime

    metric_id: BillableMetricId

    name: str

    product_family_id: ProductFamilyId

    aggregation_key: t.Optional[str] = None

    description: t.Optional[str] = None

    product_id: t.Optional[ProductId] = None

    segmentation_matrix: t.Optional[MetricSegmentationMatrix] = None

    unit_conversion_factor: t.Optional[int] = None

    unit_conversion_rounding: t.Optional[UnitConversionRoundingEnum] = None

    usage_group_key: t.Optional[str] = None
