# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class CouponLineItem(BaseModel):
    """The `CouponLineItem` object."""

    coupon_id: str

    name: str

    total: int
