# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class Event(BaseModel):
    """The `Event` object."""

    code: str
    """Billable metric code. Max 512 characters."""

    customer_id: str
    """Meteroid customer ID or external customer alias."""

    event_id: str
    """Unique event identifier. Max 255 characters. A UUID or ULID is recommended."""

    timestamp: str
    """RFC 3339 timestamp. Defaults to ingestion time if omitted.
    Must be between 24 hours ago and 1 hour from now. Set `allow_backfilling` to remove the past limit."""

    properties: dict[str, str] | None = None
    """Arbitrary string key-value pairs used by billable metrics for filtering and aggregation."""
