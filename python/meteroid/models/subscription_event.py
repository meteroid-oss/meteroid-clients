# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .subscription_event_data import SubscriptionEventData


@dataclasses.dataclass(kw_only=True)
class SubscriptionEvent(BaseModel):
    """The `SubscriptionEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("subscription_event_data",)

    subscription_event_data: SubscriptionEventData

    id: EventId

    timestamp: datetime

    type: EventType
