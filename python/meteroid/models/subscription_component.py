# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .price_component_id import PriceComponentId
from .product_id import ProductId
from .subscription_fee import SubscriptionFee
from .subscription_fee_billing_period_enum import SubscriptionFeeBillingPeriodEnum


@dataclasses.dataclass
class SubscriptionComponent(BaseModel):
    fee: SubscriptionFee

    name: str

    period: SubscriptionFeeBillingPeriodEnum

    price_component_id: t.Optional[PriceComponentId] = None

    product_id: t.Optional[ProductId] = None
