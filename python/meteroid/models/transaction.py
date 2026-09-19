# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .customer_payment_method_id import CustomerPaymentMethodId
from .payment_method_info import PaymentMethodInfo
from .payment_status_enum import PaymentStatusEnum
from .payment_transaction_id import PaymentTransactionId
from .payment_type_enum import PaymentTypeEnum


@dataclasses.dataclass
class Transaction(BaseModel):
    amount: int

    currency: str

    id: PaymentTransactionId

    payment_type: PaymentTypeEnum

    status: PaymentStatusEnum

    error: t.Optional[str] = None

    payment_method_id: t.Optional[CustomerPaymentMethodId] = None

    payment_method_info: t.Optional[PaymentMethodInfo] = None

    processed_at: t.Optional[datetime] = None

    provider_transaction_id: t.Optional[str] = None
