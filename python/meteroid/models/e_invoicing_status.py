# this file is @generated
import typing as t

from ..serialization import StrEnum


class EInvoicingStatus(StrEnum):
    """Whether the structured e-invoice was produced with the accounting PDF. Absent when the
    invoicing entity had not opted in at the time the invoice was issued."""

    GENERATED = "GENERATED"
    FAILED = "FAILED"


EInvoicingStatusLiteral: t.TypeAlias = t.Literal["GENERATED", "FAILED"]
"""The values of :class:`EInvoicingStatus`, which arguments take as plain strings too."""
