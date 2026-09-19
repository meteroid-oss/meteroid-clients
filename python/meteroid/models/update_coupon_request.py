# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .coupon_discount import CouponDiscount
from .plan_id import PlanId


@dataclasses.dataclass
class UpdateCouponRequest(BaseModel):
    description: t.Optional[str] = None

    discount: t.Optional[CouponDiscount] = None

    plan_ids: t.Optional[t.List[PlanId]] = None
