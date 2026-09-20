# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class OneTimePricing(BaseModel):
    quantity: int

    unit_price: Decimal
