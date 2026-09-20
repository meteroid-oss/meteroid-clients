# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum
from .pricing import Pricing


@dataclasses.dataclass
class PriceInput(BaseModel):
    cadence: BillingPeriodEnum

    currency: str

    pricing: Pricing
