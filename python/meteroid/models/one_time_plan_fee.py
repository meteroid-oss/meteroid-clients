# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class OneTimePlanFee(BaseModel):
    """One-time fee"""

    quantity: int

    unit_price: Decimal
