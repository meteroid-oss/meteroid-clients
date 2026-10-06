# this file is @generated
import typing as t

from ..serialization import StrEnum


class PlanTypeEnum(StrEnum):
    """The values of `PlanTypeEnum`; others are kept as received."""

    STANDARD = "STANDARD"
    FREE = "FREE"
    CUSTOM = "CUSTOM"


PlanTypeEnumLiteral: t.TypeAlias = t.Literal["STANDARD", "FREE", "CUSTOM"]
"""The values of :class:`PlanTypeEnum`, which arguments take as plain strings too."""
