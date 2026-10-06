# this file is @generated
import typing as t

from ..serialization import StrEnum


class BillingType(StrEnum):
    """The values of `BillingType`; others are kept as received."""

    ADVANCE = "ADVANCE"
    ARREARS = "ARREARS"


BillingTypeLiteral: t.TypeAlias = t.Literal["ADVANCE", "ARREARS"]
"""The values of :class:`BillingType`, which arguments take as plain strings too."""
