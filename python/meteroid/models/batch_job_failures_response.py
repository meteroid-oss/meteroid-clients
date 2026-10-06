# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .batch_job_item_failure_response import BatchJobItemFailureResponse


@dataclasses.dataclass(kw_only=True)
class BatchJobFailuresResponse(BaseModel):
    """The `BatchJobFailuresResponse` object."""

    data: list[BatchJobItemFailureResponse]

    total_count: int
