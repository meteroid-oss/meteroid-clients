# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .coupon import Coupon
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class CouponListResponse(BaseModel):
    data: t.List[Coupon]

    pagination_meta: PaginationResponse
