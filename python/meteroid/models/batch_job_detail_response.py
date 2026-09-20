# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .batch_job_id import BatchJobId
from .batch_job_status import BatchJobStatus
from .batch_job_type import BatchJobType


@dataclasses.dataclass
class BatchJobDetailResponse(BaseModel):
    created_at: datetime

    created_by: str

    failed_items: int

    failure_count: int

    has_error_csv: bool

    has_output: bool

    id: BatchJobId

    job_type: BatchJobType

    processed_items: int

    status: BatchJobStatus

    completed_at: t.Optional[datetime] = None

    error_csv_url: t.Optional[str] = None

    input_file_name: t.Optional[str] = None

    input_file_url: t.Optional[str] = None

    output_url: t.Optional[str] = None

    total_items: t.Optional[int] = None
