# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .customer_event_data import CustomerEventData
from .event_id import EventId
from .event_type import EventType


@dataclasses.dataclass
class CustomerEvent(BaseModel):
    """Event-specific webhook schemas for type-safe webhook payloads"""

    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("customer_event_data",)

    customer_event_data: CustomerEventData

    id: EventId

    timestamp: datetime

    type: EventType
