# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .subscription_event_data import SubscriptionEventData


@dataclasses.dataclass
class SubscriptionEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("subscription_event_data",)

    subscription_event_data: SubscriptionEventData

    id: EventId

    timestamp: datetime

    type: EventType
