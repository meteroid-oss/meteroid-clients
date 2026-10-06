# this file is @generated
import typing as t

from ..serialization import StrEnum


class SubscriptionActivationConditionEnum(StrEnum):
    """The values of `SubscriptionActivationConditionEnum`; others are kept as received."""

    ON_START = "ON_START"
    ON_CHECKOUT = "ON_CHECKOUT"
    MANUAL = "MANUAL"


SubscriptionActivationConditionEnumLiteral: t.TypeAlias = t.Literal[
    "ON_START", "ON_CHECKOUT", "MANUAL"
]
"""The values of :class:`SubscriptionActivationConditionEnum`, which arguments take as plain strings too."""
