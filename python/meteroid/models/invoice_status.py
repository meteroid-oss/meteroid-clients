# this file is @generated
import typing as t

from ..serialization import StrEnum


class InvoiceStatus(StrEnum):
    """The values of `InvoiceStatus`; others are kept as received."""

    DRAFT = "DRAFT"
    FINALIZED = "FINALIZED"
    UNCOLLECTIBLE = "UNCOLLECTIBLE"
    VOID = "VOID"
    CLOSED = "CLOSED"


InvoiceStatusLiteral: t.TypeAlias = t.Literal[
    "DRAFT", "FINALIZED", "UNCOLLECTIBLE", "VOID", "CLOSED"
]
"""The values of :class:`InvoiceStatus`, which arguments take as plain strings too."""
