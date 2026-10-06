# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class SlotPricing(BaseModel):
    """The `SlotPricing` object."""

    unit_rate: Decimal

    max_slots: int | None | Unset = UNSET

    min_slots: int | None | Unset = UNSET
