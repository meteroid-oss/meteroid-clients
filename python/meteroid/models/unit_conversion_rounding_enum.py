# this file is @generated
import typing as t

from ..serialization import StrEnum


class UnitConversionRoundingEnum(StrEnum):
    """The values of `UnitConversionRoundingEnum`; others are kept as received."""

    UP = "UP"
    DOWN = "DOWN"
    NEAREST = "NEAREST"
    NEAREST_HALF = "NEAREST_HALF"
    NEAREST_DECILE = "NEAREST_DECILE"
    NONE = "NONE"


UnitConversionRoundingEnumLiteral: t.TypeAlias = t.Literal[
    "UP", "DOWN", "NEAREST", "NEAREST_HALF", "NEAREST_DECILE", "NONE"
]
"""The values of :class:`UnitConversionRoundingEnum`, which arguments take as plain strings too."""
