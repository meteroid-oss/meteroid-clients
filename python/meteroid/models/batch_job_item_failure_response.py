# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from uuid import UUID

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .batch_job_chunk_id import BatchJobChunkId


@dataclasses.dataclass(kw_only=True)
class BatchJobItemFailureResponse(BaseModel):
    """The `BatchJobItemFailureResponse` object."""

    chunk_id: BatchJobChunkId

    id: UUID

    item_index: int

    reason: str

    item_identifier: str | None = None
