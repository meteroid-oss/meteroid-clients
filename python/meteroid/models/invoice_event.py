# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .invoice_event_data import InvoiceEventData


@dataclasses.dataclass
class InvoiceEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("invoice_event_data",)

    invoice_event_data: InvoiceEventData

    id: EventId

    timestamp: datetime

    type: EventType
