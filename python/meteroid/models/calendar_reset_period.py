# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .calendar_unit import CalendarUnit


@dataclasses.dataclass(kw_only=True)
class CalendarResetPeriod(BaseModel):
    """Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start date."""

    interval: int

    unit: CalendarUnit
