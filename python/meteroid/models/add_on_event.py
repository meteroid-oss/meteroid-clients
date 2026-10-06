# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .add_on_event_data import AddOnEventData
    from .event_id import EventId
    from .event_type import EventType


@dataclasses.dataclass(kw_only=True)
class AddOnEvent(BaseModel):
    """The `AddOnEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("add_on_event_data",)

    add_on_event_data: AddOnEventData

    id: EventId

    timestamp: datetime

    type: EventType
