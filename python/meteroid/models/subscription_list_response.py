# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .pagination_response import PaginationResponse
from .subscription import Subscription


@dataclasses.dataclass
class SubscriptionListResponse(BaseModel):
    data: t.List[Subscription]

    pagination_meta: PaginationResponse
