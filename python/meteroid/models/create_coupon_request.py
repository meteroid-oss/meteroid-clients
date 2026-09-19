# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .coupon_discount import CouponDiscount
from .plan_id import PlanId


@dataclasses.dataclass
class CreateCouponRequest(BaseModel):
    code: str

    discount: CouponDiscount

    description: t.Optional[str] = None

    expires_at: t.Optional[datetime] = None

    plan_ids: t.Optional[t.List[PlanId]] = None

    recurring_value: t.Optional[int] = None

    redemption_limit: t.Optional[int] = None

    reusable: t.Optional[bool] = None
