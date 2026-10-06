# this file is @generated
import typing as t

from ..serialization import StrEnum


class ProductFeeTypeEnum(StrEnum):
    """The values of `ProductFeeTypeEnum`; others are kept as received."""

    RATE = "RATE"
    SLOT = "SLOT"
    CAPACITY = "CAPACITY"
    USAGE = "USAGE"
    EXTRA_RECURRING = "EXTRA_RECURRING"
    ONE_TIME = "ONE_TIME"


ProductFeeTypeEnumLiteral: t.TypeAlias = t.Literal[
    "RATE", "SLOT", "CAPACITY", "USAGE", "EXTRA_RECURRING", "ONE_TIME"
]
"""The values of :class:`ProductFeeTypeEnum`, which arguments take as plain strings too."""
