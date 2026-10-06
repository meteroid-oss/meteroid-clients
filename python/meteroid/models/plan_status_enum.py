# this file is @generated
import typing as t

from ..serialization import StrEnum


class PlanStatusEnum(StrEnum):
    """The values of `PlanStatusEnum`; others are kept as received."""

    DRAFT = "DRAFT"
    ACTIVE = "ACTIVE"
    INACTIVE = "INACTIVE"
    ARCHIVED = "ARCHIVED"


PlanStatusEnumLiteral: t.TypeAlias = t.Literal[
    "DRAFT", "ACTIVE", "INACTIVE", "ARCHIVED"
]
"""The values of :class:`PlanStatusEnum`, which arguments take as plain strings too."""
