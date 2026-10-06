# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
    from .metric_segmentation_matrix import MetricSegmentationMatrix
    from .product_family_id import ProductFamilyId
    from .product_id import ProductId
    from .unit_conversion_rounding_enum import UnitConversionRoundingEnum


@dataclasses.dataclass(kw_only=True)
class MetricEventData(BaseModel):
    """The `MetricEventData` object."""

    aggregation_type: BillingMetricAggregateEnum

    code: str

    created_at: datetime

    metric_id: BillableMetricId

    name: str

    product_family_id: ProductFamilyId

    aggregation_key: str | None = None

    description: str | None = None

    product_id: ProductId | None = None

    segmentation_matrix: MetricSegmentationMatrix | None = None

    unit_conversion_factor: int | None = None

    unit_conversion_rounding: UnitConversionRoundingEnum | None = None

    usage_group_key: str | None = None
