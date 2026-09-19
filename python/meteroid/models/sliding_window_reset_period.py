# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .calendar_unit import CalendarUnit


@dataclasses.dataclass
class SlidingWindowResetPeriod(BaseModel):
    """Always ends at now — e.g. 30 days means the last 30 days, old usage drops off automatically."""

    interval: int

    unit: CalendarUnit
