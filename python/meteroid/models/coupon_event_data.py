# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .coupon_discount import CouponDiscount
from .coupon_id import CouponId


@dataclasses.dataclass
class CouponEventData(BaseModel):
    code: str

    coupon_id: CouponId

    created_at: datetime

    description: str

    disabled: bool

    discount: CouponDiscount

    reusable: bool

    expires_at: t.Optional[datetime] = None

    recurring_value: t.Optional[int] = None

    redemption_limit: t.Optional[int] = None
