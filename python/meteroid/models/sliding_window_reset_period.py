# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .calendar_unit import CalendarUnit


@dataclasses.dataclass(kw_only=True)
class SlidingWindowResetPeriod(BaseModel):
    """Always ends at now — e.g. 30 days means the last 30 days, old usage drops off automatically."""

    interval: int

    unit: CalendarUnit
