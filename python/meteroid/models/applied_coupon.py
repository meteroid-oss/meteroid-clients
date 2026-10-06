# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .applied_coupon_id import AppliedCouponId
    from .coupon_id import CouponId


@dataclasses.dataclass(kw_only=True)
class AppliedCoupon(BaseModel):
    """The `AppliedCoupon` object."""

    coupon_id: CouponId

    created_at: datetime

    id: AppliedCouponId

    is_active: bool

    applied_amount: Decimal | None = None

    applied_count: int | None = None

    last_applied_at: datetime | None = None
