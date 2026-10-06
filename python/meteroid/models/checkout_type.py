# this file is @generated
import typing as t

from ..serialization import StrEnum


class CheckoutType(StrEnum):
    """The values of `CheckoutType`; others are kept as received."""

    SELF_SERVE = "SELF_SERVE"
    SUBSCRIPTION_ACTIVATION = "SUBSCRIPTION_ACTIVATION"
    PLAN_CHANGE = "PLAN_CHANGE"
    ADDON_PURCHASE = "ADDON_PURCHASE"


CheckoutTypeLiteral: t.TypeAlias = t.Literal[
    "SELF_SERVE", "SUBSCRIPTION_ACTIVATION", "PLAN_CHANGE", "ADDON_PURCHASE"
]
"""The values of :class:`CheckoutType`, which arguments take as plain strings too."""
