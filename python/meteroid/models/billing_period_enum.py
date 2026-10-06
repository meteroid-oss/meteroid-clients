# this file is @generated
import typing as t

from ..serialization import StrEnum


class BillingPeriodEnum(StrEnum):
    """The values of `BillingPeriodEnum`; others are kept as received."""

    MONTHLY = "MONTHLY"
    QUARTERLY = "QUARTERLY"
    SEMIANNUAL = "SEMIANNUAL"
    ANNUAL = "ANNUAL"


BillingPeriodEnumLiteral: t.TypeAlias = t.Literal[
    "MONTHLY", "QUARTERLY", "SEMIANNUAL", "ANNUAL"
]
"""The values of :class:`BillingPeriodEnum`, which arguments take as plain strings too."""
