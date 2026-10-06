# this file is @generated
import typing as t

from ..serialization import StrEnum


class CustomPropertyEntityType(StrEnum):
    """The values of `CustomPropertyEntityType`; others are kept as received."""

    CUSTOMER = "CUSTOMER"
    SUBSCRIPTION = "SUBSCRIPTION"
    INVOICE = "INVOICE"
    CREDIT_NOTE = "CREDIT_NOTE"


CustomPropertyEntityTypeLiteral: t.TypeAlias = t.Literal[
    "CUSTOMER", "SUBSCRIPTION", "INVOICE", "CREDIT_NOTE"
]
"""The values of :class:`CustomPropertyEntityType`, which arguments take as plain strings too."""
