# this file is @generated
import typing as t

from ..serialization import StrEnum


class PaymentStatusEnum(StrEnum):
    """The values of `PaymentStatusEnum`; others are kept as received."""

    READY = "READY"
    PENDING = "PENDING"
    SETTLED = "SETTLED"
    CANCELLED = "CANCELLED"
    FAILED = "FAILED"
    REFUNDED = "REFUNDED"


PaymentStatusEnumLiteral: t.TypeAlias = t.Literal[
    "READY", "PENDING", "SETTLED", "CANCELLED", "FAILED", "REFUNDED"
]
"""The values of :class:`PaymentStatusEnum`, which arguments take as plain strings too."""
