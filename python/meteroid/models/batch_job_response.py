# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .batch_job_id import BatchJobId
from .batch_job_status import BatchJobStatus
from .batch_job_type import BatchJobType


@dataclasses.dataclass
class BatchJobResponse(BaseModel):
    created_at: datetime

    created_by: str

    failed_items: int

    id: BatchJobId

    job_type: BatchJobType

    processed_items: int

    status: BatchJobStatus

    completed_at: t.Optional[datetime] = None

    input_file_name: t.Optional[str] = None

    total_items: t.Optional[int] = None
