# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel
from .billing_type_enum import BillingTypeEnum


@dataclasses.dataclass
class RecurringFee(BaseModel):
    billing_type: BillingTypeEnum

    quantity: int

    rate: Decimal
