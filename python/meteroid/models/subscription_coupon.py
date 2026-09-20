# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .coupon_discount import CouponDiscount
from .coupon_id import CouponId


@dataclasses.dataclass
class SubscriptionCoupon(BaseModel):
    """Coupon as embedded in subscription details — a subset of the `Coupon` resource
    returned by the coupons API."""

    code: str

    description: str

    disabled: bool

    discount: CouponDiscount

    id: CouponId

    reusable: bool

    expires_at: t.Optional[datetime] = None

    recurring_value: t.Optional[int] = None

    redemption_limit: t.Optional[int] = None
