# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .billing_period_enum import BillingPeriodEnum
from .capacity_threshold import CapacityThreshold


@dataclasses.dataclass
class CapacityPlanFee(BaseModel):
    """Capacity-based fee with included committed usage and overage"""

    cadence: BillingPeriodEnum

    metric_id: BillableMetricId

    thresholds: t.List[CapacityThreshold]
