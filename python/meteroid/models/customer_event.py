# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_event_data import CustomerEventData
    from .event_id import EventId
    from .event_type import EventType


@dataclasses.dataclass(kw_only=True)
class CustomerEvent(BaseModel):
    """Event-specific webhook schemas for type-safe webhook payloads"""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("customer_event_data",)

    customer_event_data: CustomerEventData

    id: EventId

    timestamp: datetime

    type: EventType
