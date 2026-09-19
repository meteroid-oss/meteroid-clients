# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .usage_pricing_model import UsagePricingModel


@dataclasses.dataclass
class UsageFee(BaseModel):
    metric_id: BillableMetricId

    model: UsagePricingModel
