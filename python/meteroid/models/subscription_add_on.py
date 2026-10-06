# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .add_on_id import AddOnId
    from .subscription_add_on_id import SubscriptionAddOnId
    from .subscription_fee import SubscriptionFee
    from .subscription_fee_billing_period_enum import SubscriptionFeeBillingPeriodEnum


@dataclasses.dataclass(kw_only=True)
class SubscriptionAddOn(BaseModel):
    """The `SubscriptionAddOn` object."""

    fee: SubscriptionFee

    name: str

    period: SubscriptionFeeBillingPeriodEnum

    quantity: int

    add_on_id: AddOnId | None = None

    id: SubscriptionAddOnId | None = None
