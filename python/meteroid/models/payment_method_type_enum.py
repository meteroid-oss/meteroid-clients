# this file is @generated
import typing as t

from ..serialization import StrEnum


class PaymentMethodTypeEnum(StrEnum):
    """The values of `PaymentMethodTypeEnum`; others are kept as received."""

    CARD = "CARD"
    BANK_TRANSFER = "BANK_TRANSFER"
    WALLET = "WALLET"
    OTHER = "OTHER"


PaymentMethodTypeEnumLiteral: t.TypeAlias = t.Literal[
    "CARD", "BANK_TRANSFER", "WALLET", "OTHER"
]
"""The values of :class:`PaymentMethodTypeEnum`, which arguments take as plain strings too."""
