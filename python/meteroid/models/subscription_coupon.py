# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .coupon_discount import CouponDiscount
    from .coupon_id import CouponId


@dataclasses.dataclass(kw_only=True)
class SubscriptionCoupon(BaseModel):
    """Coupon as embedded in subscription details — a subset of the `Coupon` resource
    returned by the coupons API."""

    code: str

    description: str

    disabled: bool

    discount: CouponDiscount

    id: CouponId

    reusable: bool

    expires_at: datetime | None = None

    recurring_value: int | None = None

    redemption_limit: int | None = None
