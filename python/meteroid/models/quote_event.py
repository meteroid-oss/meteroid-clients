# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .quote_event_data import QuoteEventData


@dataclasses.dataclass
class QuoteEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("quote_event_data",)

    quote_event_data: QuoteEventData

    id: EventId

    timestamp: datetime

    type: EventType
