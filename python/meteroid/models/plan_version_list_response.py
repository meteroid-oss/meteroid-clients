# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .pagination_response import PaginationResponse
from .plan_version_summary import PlanVersionSummary


@dataclasses.dataclass
class PlanVersionListResponse(BaseModel):
    data: t.List[PlanVersionSummary]

    pagination_meta: PaginationResponse
