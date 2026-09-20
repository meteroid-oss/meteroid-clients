# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .batch_job_chunk_id import BatchJobChunkId


@dataclasses.dataclass
class BatchJobItemFailureResponse(BaseModel):
    chunk_id: BatchJobChunkId

    id: str

    item_index: int

    reason: str

    item_identifier: t.Optional[str] = None
