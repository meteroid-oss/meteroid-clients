# this file is @generated
import typing as t

from ..serialization import StrEnum


class CheckoutSessionStatus(StrEnum):
    """The values of `CheckoutSessionStatus`; others are kept as received."""

    CREATED = "CREATED"
    AWAITING_PAYMENT = "AWAITING_PAYMENT"
    COMPLETED = "COMPLETED"
    EXPIRED = "EXPIRED"
    CANCELLED = "CANCELLED"


CheckoutSessionStatusLiteral: t.TypeAlias = t.Literal[
    "CREATED", "AWAITING_PAYMENT", "COMPLETED", "EXPIRED", "CANCELLED"
]
"""The values of :class:`CheckoutSessionStatus`, which arguments take as plain strings too."""
