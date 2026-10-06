# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .coupon import Coupon
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class CouponListResponse(BaseModel):
    """The `CouponListResponse` object."""

    data: list[Coupon]

    pagination_meta: PaginationResponse
