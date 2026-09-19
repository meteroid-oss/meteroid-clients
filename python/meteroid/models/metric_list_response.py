# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .metric_summary import MetricSummary
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class MetricListResponse(BaseModel):
    data: t.List[MetricSummary]

    pagination_meta: PaginationResponse
