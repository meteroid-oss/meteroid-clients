# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
    from .metric_filter import MetricFilter
    from .metric_segmentation_matrix import MetricSegmentationMatrix
    from .product_family_id import ProductFamilyId
    from .product_id import ProductId
    from .unit_conversion import UnitConversion


@dataclasses.dataclass(kw_only=True)
class Metric(BaseModel):
    """The `Metric` object."""

    aggregation_type: BillingMetricAggregateEnum

    code: str

    created_at: datetime

    id: BillableMetricId

    name: str

    product_family_id: ProductFamilyId

    aggregation_key: str | None = None

    archived_at: datetime | None = None

    description: str | None = None

    filters: list[MetricFilter] | None = None

    product_id: ProductId | None = None

    segmentation_matrix: MetricSegmentationMatrix | None = None

    unit_conversion: UnitConversion | None = None

    usage_group_key: str | None = None
