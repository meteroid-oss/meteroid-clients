# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class TierRow(BaseModel):
    first_unit: int

    rate: Decimal

    flat_cap: t.Optional[Decimal] = None

    flat_fee: t.Optional[Decimal] = None
