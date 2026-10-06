# this file is @generated
import typing as t

from ..serialization import StrEnum


class PaymentTypeEnum(StrEnum):
    """The values of `PaymentTypeEnum`; others are kept as received."""

    PAYMENT = "PAYMENT"
    REFUND = "REFUND"


PaymentTypeEnumLiteral: t.TypeAlias = t.Literal["PAYMENT", "REFUND"]
"""The values of :class:`PaymentTypeEnum`, which arguments take as plain strings too."""
