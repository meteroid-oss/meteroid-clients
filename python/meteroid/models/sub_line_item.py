# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class SubLineItem(BaseModel):
    id: str

    name: str

    quantity: Decimal

    total: int

    unit_price: Decimal
