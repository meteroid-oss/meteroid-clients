# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .coupon_discount import CouponDiscount
    from .coupon_id import CouponId
    from .plan_id import PlanId


@dataclasses.dataclass(kw_only=True)
class Coupon(BaseModel):
    """The `Coupon` object."""

    code: str

    created_at: datetime

    disabled: bool

    discount: CouponDiscount

    id: CouponId

    plan_ids: list[PlanId]

    redemption_count: int

    reusable: bool

    archived_at: datetime | None = None

    description: str | None = None

    expires_at: datetime | None = None

    recurring_value: int | None = None

    redemption_limit: int | None = None
