# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .billing_period_enum import BillingPeriodEnum
    from .plan_usage_pricing_model import PlanUsagePricingModel


@dataclasses.dataclass(kw_only=True)
class UsagePlanFee(BaseModel):
    """Usage-based fee"""

    cadence: BillingPeriodEnum

    metric_id: BillableMetricId

    pricing: PlanUsagePricingModel
