# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass
class TermRate(BaseModel):
    price: Decimal

    term: BillingPeriodEnum
