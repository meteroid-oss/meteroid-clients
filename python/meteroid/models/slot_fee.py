# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class SlotFee(BaseModel):
    """The `SlotFee` object."""

    initial_slots: int

    unit: str

    unit_rate: Decimal

    max_slots: int | None = None

    min_slots: int | None = None
