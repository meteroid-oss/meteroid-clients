# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .calendar_unit import CalendarUnit


@dataclasses.dataclass
class CalendarResetPeriod(BaseModel):
    """Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start date."""

    interval: int

    unit: CalendarUnit
