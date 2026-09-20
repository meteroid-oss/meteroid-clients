# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class SlotFee(BaseModel):
    initial_slots: int

    unit: str

    unit_rate: Decimal

    max_slots: t.Optional[int] = None

    min_slots: t.Optional[int] = None
