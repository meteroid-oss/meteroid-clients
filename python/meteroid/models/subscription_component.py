# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .price_component_id import PriceComponentId
    from .product_id import ProductId
    from .subscription_fee import SubscriptionFee
    from .subscription_fee_billing_period_enum import SubscriptionFeeBillingPeriodEnum


@dataclasses.dataclass(kw_only=True)
class SubscriptionComponent(BaseModel):
    """The `SubscriptionComponent` object."""

    fee: SubscriptionFee

    name: str

    period: SubscriptionFeeBillingPeriodEnum

    price_component_id: PriceComponentId | None = None

    product_id: ProductId | None = None
