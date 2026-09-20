# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum
from .billing_type import BillingType


@dataclasses.dataclass
class ExtraRecurringPlanFee(BaseModel):
    """Extra recurring fee"""

    billing_type: BillingType

    cadence: BillingPeriodEnum

    quantity: int

    unit_price: Decimal
