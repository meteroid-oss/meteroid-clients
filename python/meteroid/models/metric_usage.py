# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .grouped_usage import GroupedUsage


@dataclasses.dataclass(kw_only=True)
class MetricUsage(BaseModel):
    """The `MetricUsage` object."""

    grouped_usage: list[GroupedUsage]

    metric_code: str

    metric_id: BillableMetricId

    metric_name: str

    total_value: Decimal
