# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .applied_coupon import AppliedCoupon
    from .subscription_coupon import SubscriptionCoupon


@dataclasses.dataclass(kw_only=True)
class AppliedCouponDetailed(BaseModel):
    """The `AppliedCouponDetailed` object."""

    applied_coupon: AppliedCoupon

    coupon: SubscriptionCoupon
