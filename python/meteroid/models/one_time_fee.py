# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class OneTimeFee(BaseModel):
    """The `OneTimeFee` object."""

    quantity: int

    rate: Decimal
