# this file is @generated
import typing as t

from ..serialization import StrEnum


class CalendarUnit(StrEnum):
    """The values of `CalendarUnit`; others are kept as received."""

    HOUR = "HOUR"
    DAY = "DAY"
    WEEK = "WEEK"
    MONTH = "MONTH"
    YEAR = "YEAR"


CalendarUnitLiteral: t.TypeAlias = t.Literal["HOUR", "DAY", "WEEK", "MONTH", "YEAR"]
"""The values of :class:`CalendarUnit`, which arguments take as plain strings too."""
