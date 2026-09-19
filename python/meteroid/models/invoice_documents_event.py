# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .invoice_documents_event_data import InvoiceDocumentsEventData


@dataclasses.dataclass
class InvoiceDocumentsEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("invoice_documents_event_data",)

    invoice_documents_event_data: InvoiceDocumentsEventData

    id: EventId

    timestamp: datetime

    type: EventType
