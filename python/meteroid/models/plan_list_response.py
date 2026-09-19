# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .pagination_response import PaginationResponse
from .plan import Plan


@dataclasses.dataclass
class PlanListResponse(BaseModel):
    data: t.List[Plan]

    pagination_meta: PaginationResponse
