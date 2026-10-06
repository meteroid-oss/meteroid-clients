# this file is @generated
import typing as t

from ..serialization import StrEnum


class SubscriptionFeeBillingPeriodEnum(StrEnum):
    """The values of `SubscriptionFeeBillingPeriodEnum`; others are kept as received."""

    ONE_TIME = "ONE_TIME"
    MONTHLY = "MONTHLY"
    QUARTERLY = "QUARTERLY"
    SEMIANNUAL = "SEMIANNUAL"
    ANNUAL = "ANNUAL"


SubscriptionFeeBillingPeriodEnumLiteral: t.TypeAlias = t.Literal[
    "ONE_TIME", "MONTHLY", "QUARTERLY", "SEMIANNUAL", "ANNUAL"
]
"""The values of :class:`SubscriptionFeeBillingPeriodEnum`, which arguments take as plain strings too."""
