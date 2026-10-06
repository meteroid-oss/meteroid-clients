# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class OneTimePricing(BaseModel):
    """The `OneTimePricing` object."""

    quantity: int

    unit_price: Decimal
