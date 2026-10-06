# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .billing_metric_aggregate_enum import BillingMetricAggregateEnum
    from .metric_filter import MetricFilter
    from .metric_segmentation_matrix import MetricSegmentationMatrix
    from .product_family_id import ProductFamilyId
    from .product_id import ProductId
    from .unit_conversion import UnitConversion


@dataclasses.dataclass(kw_only=True)
class CreateMetricRequest(BaseModel):
    """The `CreateMetricRequest` object."""

    aggregation_type: BillingMetricAggregateEnum

    code: str

    name: str

    product_family_id: ProductFamilyId

    aggregation_key: str | None | Unset = UNSET

    description: str | None | Unset = UNSET

    filters: list[MetricFilter] | None | Unset = UNSET
    """Pre-aggregation property filters. Optional and backward-compatible; omit for none."""

    product_id: ProductId | None | Unset = UNSET

    segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET

    unit_conversion: UnitConversion | None | Unset = UNSET

    usage_group_key: str | None | Unset = UNSET
