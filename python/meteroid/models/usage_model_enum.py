# this file is @generated
import typing as t

from ..serialization import StrEnum


class UsageModelEnum(StrEnum):
    """The values of `UsageModelEnum`; others are kept as received."""

    PER_UNIT = "PER_UNIT"
    TIERED = "TIERED"
    VOLUME = "VOLUME"
    PACKAGE = "PACKAGE"
    MATRIX = "MATRIX"


UsageModelEnumLiteral: t.TypeAlias = t.Literal[
    "PER_UNIT", "TIERED", "VOLUME", "PACKAGE", "MATRIX"
]
"""The values of :class:`UsageModelEnum`, which arguments take as plain strings too."""
