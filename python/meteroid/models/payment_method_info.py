# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .payment_method_type_enum import PaymentMethodTypeEnum


@dataclasses.dataclass
class PaymentMethodInfo(BaseModel):
    payment_method_type: PaymentMethodTypeEnum

    account_number_hint: t.Optional[str] = None

    card_brand: t.Optional[str] = None

    card_last4: t.Optional[str] = None
