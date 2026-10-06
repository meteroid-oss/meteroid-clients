# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .term_rate import TermRate


@dataclasses.dataclass(kw_only=True)
class SlotPlanFee(BaseModel):
    """Slot-based fee (e.g., per-seat pricing)"""

    rates: list[TermRate]

    slot_unit_name: str

    minimum_count: int | None | Unset = UNSET

    quota: int | None | Unset = UNSET
