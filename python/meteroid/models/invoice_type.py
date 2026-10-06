# this file is @generated
import typing as t

from ..serialization import StrEnum


class InvoiceType(StrEnum):
    """The values of `InvoiceType`; others are kept as received."""

    RECURRING = "RECURRING"
    ONE_OFF = "ONE_OFF"
    ADJUSTMENT = "ADJUSTMENT"
    USAGE_THRESHOLD = "USAGE_THRESHOLD"


InvoiceTypeLiteral: t.TypeAlias = t.Literal[
    "RECURRING", "ONE_OFF", "ADJUSTMENT", "USAGE_THRESHOLD"
]
"""The values of :class:`InvoiceType`, which arguments take as plain strings too."""
