# this file is @generated
import typing as t

from ..serialization import StrEnum


class BillingTypeEnum(StrEnum):
    """The values of `BillingTypeEnum`; others are kept as received."""

    ADVANCE = "ADVANCE"
    ARREARS = "ARREARS"


BillingTypeEnumLiteral: t.TypeAlias = t.Literal["ADVANCE", "ARREARS"]
"""The values of :class:`BillingTypeEnum`, which arguments take as plain strings too."""
