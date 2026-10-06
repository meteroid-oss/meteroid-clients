# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .event import Event


@dataclasses.dataclass(kw_only=True)
class IngestEventsRequest(BaseModel):
    """The `IngestEventsRequest` object."""

    events: list[Event]
    """1–100 events per request."""

    allow_backfilling: bool | None | Unset = UNSET
    """Allow events with timestamps more than 1 day in the past. Defaults to `false`."""

    allow_partial_failures: bool | None | Unset = UNSET
    """Accept the batch even if some events fail validation. Defaults to `false`.
    When `true`, valid events are ingested and failures are reported in the response body.
    When `false` (default), any invalid event rejects the entire batch."""
