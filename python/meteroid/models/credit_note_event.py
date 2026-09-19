# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .credit_note_event_data import CreditNoteEventData
from .event_id import EventId
from .event_type import EventType


@dataclasses.dataclass
class CreditNoteEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("credit_note_event_data",)

    credit_note_event_data: CreditNoteEventData

    id: EventId

    timestamp: datetime

    type: EventType
