# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .quote_event_data import QuoteEventData


@dataclasses.dataclass(kw_only=True)
class QuoteEvent(BaseModel):
    """The `QuoteEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("quote_event_data",)

    quote_event_data: QuoteEventData

    id: EventId

    timestamp: datetime

    type: EventType
