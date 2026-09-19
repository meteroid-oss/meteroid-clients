# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class Event(BaseModel):
    code: str
    """Billable metric code. Max 512 characters."""

    customer_id: str
    """Meteroid customer ID or external customer alias."""

    event_id: str
    """Unique event identifier. Max 255 characters. A UUID or ULID is recommended."""

    timestamp: str
    """RFC 3339 timestamp. Defaults to ingestion time if omitted.
    Must be between 24 hours ago and 1 hour from now. Set `allow_backfilling` to remove the past limit."""

    properties: t.Optional[t.Dict[str, str]] = None
    """Arbitrary string key-value pairs used by billable metrics for filtering and aggregation."""
