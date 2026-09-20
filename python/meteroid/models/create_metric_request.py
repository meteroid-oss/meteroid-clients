# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
from .metric_filter import MetricFilter
from .metric_segmentation_matrix import MetricSegmentationMatrix
from .product_family_id import ProductFamilyId
from .product_id import ProductId
from .unit_conversion import UnitConversion


@dataclasses.dataclass
class CreateMetricRequest(BaseModel):
    aggregation_type: BillingMetricAggregateEnum

    code: str

    name: str

    product_family_id: ProductFamilyId

    aggregation_key: t.Optional[str] = None

    description: t.Optional[str] = None

    filters: t.Optional[t.List[MetricFilter]] = None
    """Pre-aggregation property filters. Optional and backward-compatible; omit for none."""

    product_id: t.Optional[ProductId] = None

    segmentation_matrix: t.Optional[MetricSegmentationMatrix] = None

    unit_conversion: t.Optional[UnitConversion] = None

    usage_group_key: t.Optional[str] = None
