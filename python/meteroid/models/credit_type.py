# this file is @generated
import typing as t

from ..serialization import StrEnum


class CreditType(StrEnum):
    """The values of `CreditType`; others are kept as received."""

    CREDIT_TO_BALANCE = "CREDIT_TO_BALANCE"
    REFUND = "REFUND"
    DEBT_CANCELLATION = "DEBT_CANCELLATION"


CreditTypeLiteral: t.TypeAlias = t.Literal[
    "CREDIT_TO_BALANCE", "REFUND", "DEBT_CANCELLATION"
]
"""The values of :class:`CreditType`, which arguments take as plain strings too."""
