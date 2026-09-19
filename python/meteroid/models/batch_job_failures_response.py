# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .batch_job_item_failure_response import BatchJobItemFailureResponse


@dataclasses.dataclass
class BatchJobFailuresResponse(BaseModel):
    data: t.List[BatchJobItemFailureResponse]

    total_count: int
