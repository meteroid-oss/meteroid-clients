# this file is @generated
import typing as t

from ..serialization import StrEnum


class ExtraRecurringBillingTypeEnum(StrEnum):
    """The values of `ExtraRecurringBillingTypeEnum`; others are kept as received."""

    ADVANCE = "ADVANCE"
    ARREARS = "ARREARS"


ExtraRecurringBillingTypeEnumLiteral: t.TypeAlias = t.Literal["ADVANCE", "ARREARS"]
"""The values of :class:`ExtraRecurringBillingTypeEnum`, which arguments take as plain strings too."""
