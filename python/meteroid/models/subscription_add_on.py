# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .add_on_id import AddOnId
from .subscription_add_on_id import SubscriptionAddOnId
from .subscription_fee import SubscriptionFee
from .subscription_fee_billing_period_enum import SubscriptionFeeBillingPeriodEnum


@dataclasses.dataclass
class SubscriptionAddOn(BaseModel):
    fee: SubscriptionFee

    name: str

    period: SubscriptionFeeBillingPeriodEnum

    quantity: int

    add_on_id: t.Optional[AddOnId] = None

    id: t.Optional[SubscriptionAddOnId] = None
