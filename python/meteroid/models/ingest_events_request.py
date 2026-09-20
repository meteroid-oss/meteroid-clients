# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .event import Event


@dataclasses.dataclass
class IngestEventsRequest(BaseModel):
    events: t.List[Event]
    """1–100 events per request."""

    allow_backfilling: t.Optional[bool] = None
    """Allow events with timestamps more than 1 day in the past. Defaults to `false`."""

    allow_partial_failures: t.Optional[bool] = None
    """Accept the batch even if some events fail validation. Defaults to `false`.
    When `true`, valid events are ingested and failures are reported in the response body.
    When `false` (default), any invalid event rejects the entire batch."""
