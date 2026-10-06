# this file is @generated
import typing as t

from ..serialization import StrEnum


class CouponFilter(StrEnum):
    """The values of `CouponFilter`; others are kept as received."""

    ALL = "ALL"
    ACTIVE = "ACTIVE"
    INACTIVE = "INACTIVE"
    ARCHIVED = "ARCHIVED"


CouponFilterLiteral: t.TypeAlias = t.Literal["ALL", "ACTIVE", "INACTIVE", "ARCHIVED"]
"""The values of :class:`CouponFilter`, which arguments take as plain strings too."""
