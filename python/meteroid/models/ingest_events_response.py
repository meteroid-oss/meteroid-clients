# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .ingest_failure import IngestFailure


@dataclasses.dataclass
class IngestEventsResponse(BaseModel):
    failures: t.Optional[t.List[IngestFailure]] = None
    """Events that failed to ingest. Omitted when no failures."""
