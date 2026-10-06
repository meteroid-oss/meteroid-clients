# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .coupon_discount import CouponDiscount
    from .plan_id import PlanId


@dataclasses.dataclass(kw_only=True)
class UpdateCouponRequest(BaseModel):
    """The `UpdateCouponRequest` object."""

    description: str | None | Unset = UNSET

    discount: CouponDiscount | None | Unset = UNSET

    plan_ids: list[PlanId] | None | Unset = UNSET
