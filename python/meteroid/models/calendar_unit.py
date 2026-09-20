# this file is @generated
import enum


class CalendarUnit(str, enum.Enum):
    HOUR = "HOUR"
    DAY = "DAY"
    WEEK = "WEEK"
    MONTH = "MONTH"
    YEAR = "YEAR"

    def __str__(self) -> str:
        return str(self.value)
