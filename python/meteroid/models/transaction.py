# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_payment_method_id import CustomerPaymentMethodId
    from .payment_method_info import PaymentMethodInfo
    from .payment_status_enum import PaymentStatusEnum
    from .payment_transaction_id import PaymentTransactionId
    from .payment_type_enum import PaymentTypeEnum


@dataclasses.dataclass(kw_only=True)
class Transaction(BaseModel):
    """The `Transaction` object."""

    amount: int

    currency: str

    id: PaymentTransactionId

    payment_type: PaymentTypeEnum

    status: PaymentStatusEnum

    error: str | None = None

    payment_method_id: CustomerPaymentMethodId | None = None

    payment_method_info: PaymentMethodInfo | None = None

    processed_at: datetime | None = None

    provider_transaction_id: str | None = None
