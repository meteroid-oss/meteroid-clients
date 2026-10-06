# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class SubLineItem(BaseModel):
    """The `SubLineItem` object."""

    id: str

    name: str

    quantity: Decimal

    total: int

    unit_price: Decimal
