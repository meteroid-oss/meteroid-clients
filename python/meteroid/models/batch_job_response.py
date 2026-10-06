# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime
from uuid import UUID

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .batch_job_id import BatchJobId
    from .batch_job_status import BatchJobStatus
    from .batch_job_type import BatchJobType


@dataclasses.dataclass(kw_only=True)
class BatchJobResponse(BaseModel):
    """The `BatchJobResponse` object."""

    created_at: datetime

    created_by: UUID

    failed_items: int

    id: BatchJobId

    job_type: BatchJobType

    processed_items: int

    status: BatchJobStatus

    completed_at: datetime | None = None

    input_file_name: str | None = None

    total_items: int | None = None
