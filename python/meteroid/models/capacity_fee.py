# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId


@dataclasses.dataclass
class CapacityFee(BaseModel):
    included: int

    metric_id: BillableMetricId

    overage_rate: Decimal

    rate: Decimal
