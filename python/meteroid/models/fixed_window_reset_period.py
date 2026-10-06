# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .calendar_unit import CalendarUnit


@dataclasses.dataclass(kw_only=True)
class FixedWindowResetPeriod(BaseModel):
    """Resets at regular intervals — anchored to your subscription's exact activation time."""

    interval: int

    unit: CalendarUnit
