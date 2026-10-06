# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .plan_event_data import PlanEventData


@dataclasses.dataclass(kw_only=True)
class PlanEvent(BaseModel):
    """The `PlanEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("plan_event_data",)

    plan_event_data: PlanEventData

    id: EventId

    timestamp: datetime

    type: EventType
