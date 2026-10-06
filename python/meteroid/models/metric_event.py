# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .metric_event_data import MetricEventData


@dataclasses.dataclass(kw_only=True)
class MetricEvent(BaseModel):
    """The `MetricEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("metric_event_data",)

    metric_event_data: MetricEventData

    id: EventId

    timestamp: datetime

    type: EventType
