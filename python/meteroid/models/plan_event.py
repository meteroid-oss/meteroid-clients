# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .plan_event_data import PlanEventData


@dataclasses.dataclass
class PlanEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("plan_event_data",)

    plan_event_data: PlanEventData

    id: EventId

    timestamp: datetime

    type: EventType
