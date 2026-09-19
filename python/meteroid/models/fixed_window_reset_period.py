# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .calendar_unit import CalendarUnit


@dataclasses.dataclass
class FixedWindowResetPeriod(BaseModel):
    """Resets at regular intervals — anchored to your subscription's exact activation time."""

    interval: int

    unit: CalendarUnit
