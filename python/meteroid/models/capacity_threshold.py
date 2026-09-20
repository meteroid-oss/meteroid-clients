# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class CapacityThreshold(BaseModel):
    included_amount: int

    per_unit_overage: Decimal

    price: Decimal
