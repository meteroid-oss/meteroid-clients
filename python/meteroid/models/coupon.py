# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .coupon_discount import CouponDiscount
from .coupon_id import CouponId
from .plan_id import PlanId


@dataclasses.dataclass
class Coupon(BaseModel):
    code: str

    created_at: datetime

    disabled: bool

    discount: CouponDiscount

    id: CouponId

    plan_ids: t.List[PlanId]

    redemption_count: int

    reusable: bool

    archived_at: t.Optional[datetime] = None

    description: t.Optional[str] = None

    expires_at: t.Optional[datetime] = None

    recurring_value: t.Optional[int] = None

    redemption_limit: t.Optional[int] = None
