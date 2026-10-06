# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .payment_method_type_enum import PaymentMethodTypeEnum


@dataclasses.dataclass(kw_only=True)
class PaymentMethodInfo(BaseModel):
    """The `PaymentMethodInfo` object."""

    payment_method_type: PaymentMethodTypeEnum

    account_number_hint: str | None = None

    card_brand: str | None = None

    card_last4: str | None = None
