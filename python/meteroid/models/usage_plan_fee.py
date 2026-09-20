# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .billing_period_enum import BillingPeriodEnum
from .plan_usage_pricing_model import PlanUsagePricingModel


@dataclasses.dataclass
class UsagePlanFee(BaseModel):
    """Usage-based fee"""

    cadence: BillingPeriodEnum

    metric_id: BillableMetricId

    pricing: PlanUsagePricingModel
