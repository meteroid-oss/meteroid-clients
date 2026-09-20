# this file is @generated
import dataclasses
import typing as t
from datetime import datetime
from decimal import Decimal

from ..serialization import BaseModel
from .applied_coupon_id import AppliedCouponId
from .coupon_id import CouponId


@dataclasses.dataclass
class AppliedCoupon(BaseModel):
    coupon_id: CouponId

    created_at: datetime

    id: AppliedCouponId

    is_active: bool

    applied_amount: t.Optional[Decimal] = None

    applied_count: t.Optional[int] = None

    last_applied_at: t.Optional[datetime] = None
