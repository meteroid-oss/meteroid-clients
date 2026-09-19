# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class OneTimeFee(BaseModel):
    quantity: int

    rate: Decimal
