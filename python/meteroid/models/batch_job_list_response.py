# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .batch_job_response import BatchJobResponse
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class BatchJobListResponse(BaseModel):
    """The `BatchJobListResponse` object."""

    data: list[BatchJobResponse]

    pagination_meta: PaginationResponse
