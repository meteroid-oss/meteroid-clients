# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .metric_event_data import MetricEventData


@dataclasses.dataclass
class MetricEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("metric_event_data",)

    metric_event_data: MetricEventData

    id: EventId

    timestamp: datetime

    type: EventType
