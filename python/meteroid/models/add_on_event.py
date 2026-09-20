# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .add_on_event_data import AddOnEventData
from .event_id import EventId
from .event_type import EventType


@dataclasses.dataclass
class AddOnEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("add_on_event_data",)

    add_on_event_data: AddOnEventData

    id: EventId

    timestamp: datetime

    type: EventType
