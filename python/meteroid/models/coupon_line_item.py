# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class CouponLineItem(BaseModel):
    coupon_id: str

    name: str

    total: int
