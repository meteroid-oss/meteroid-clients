# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .invoice_event_data import InvoiceEventData


@dataclasses.dataclass(kw_only=True)
class InvoiceEvent(BaseModel):
    """The `InvoiceEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("invoice_event_data",)

    invoice_event_data: InvoiceEventData

    id: EventId

    timestamp: datetime

    type: EventType
