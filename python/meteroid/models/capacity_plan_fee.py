# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .billing_period_enum import BillingPeriodEnum
    from .capacity_threshold import CapacityThreshold


@dataclasses.dataclass(kw_only=True)
class CapacityPlanFee(BaseModel):
    """Capacity-based fee with included committed usage and overage"""

    cadence: BillingPeriodEnum

    metric_id: BillableMetricId

    thresholds: list[CapacityThreshold]
