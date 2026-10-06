# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .coupon_discount import CouponDiscount
    from .plan_id import PlanId


@dataclasses.dataclass(kw_only=True)
class CreateCouponRequest(BaseModel):
    """The `CreateCouponRequest` object."""

    code: str

    discount: CouponDiscount

    description: str | None | Unset = UNSET

    expires_at: datetime | None | Unset = UNSET

    plan_ids: list[PlanId] | None = None

    recurring_value: int | None | Unset = UNSET

    redemption_limit: int | None | Unset = UNSET

    reusable: bool | None = None
