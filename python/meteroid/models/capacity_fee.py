# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId


@dataclasses.dataclass(kw_only=True)
class CapacityFee(BaseModel):
    """The `CapacityFee` object."""

    included: int

    metric_id: BillableMetricId

    overage_rate: Decimal

    rate: Decimal
