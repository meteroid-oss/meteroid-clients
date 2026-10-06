# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .ingest_failure import IngestFailure


@dataclasses.dataclass(kw_only=True)
class IngestEventsResponse(BaseModel):
    """The `IngestEventsResponse` object."""

    failures: list[IngestFailure] | None = None
    """Events that failed to ingest. Omitted when no failures."""
