# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class CapacityThreshold(BaseModel):
    """The `CapacityThreshold` object."""

    included_amount: int

    per_unit_overage: Decimal

    price: Decimal
