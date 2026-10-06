# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .credit_note_event_data import CreditNoteEventData
    from .event_id import EventId
    from .event_type import EventType


@dataclasses.dataclass(kw_only=True)
class CreditNoteEvent(BaseModel):
    """The `CreditNoteEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("credit_note_event_data",)

    credit_note_event_data: CreditNoteEventData

    id: EventId

    timestamp: datetime

    type: EventType
