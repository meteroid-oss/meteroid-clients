# this file is @generated
import typing as t

from ..serialization import StrEnum


class InvoicePaymentStatus(StrEnum):
    """The values of `InvoicePaymentStatus`; others are kept as received."""

    UNPAID = "UNPAID"
    PARTIALLY_PAID = "PARTIALLY_PAID"
    PAID = "PAID"
    ERRORED = "ERRORED"
    PROCESSING = "PROCESSING"


InvoicePaymentStatusLiteral: t.TypeAlias = t.Literal[
    "UNPAID", "PARTIALLY_PAID", "PAID", "ERRORED", "PROCESSING"
]
"""The values of :class:`InvoicePaymentStatus`, which arguments take as plain strings too."""
