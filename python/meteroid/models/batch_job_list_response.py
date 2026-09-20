# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .batch_job_response import BatchJobResponse
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class BatchJobListResponse(BaseModel):
    data: t.List[BatchJobResponse]

    pagination_meta: PaginationResponse
