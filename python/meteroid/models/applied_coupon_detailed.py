# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .applied_coupon import AppliedCoupon
from .subscription_coupon import SubscriptionCoupon


@dataclasses.dataclass
class AppliedCouponDetailed(BaseModel):
    applied_coupon: AppliedCoupon

    coupon: SubscriptionCoupon
