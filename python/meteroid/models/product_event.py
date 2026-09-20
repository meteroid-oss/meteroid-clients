# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .event_id import EventId
from .event_type import EventType
from .product_event_data import ProductEventData


@dataclasses.dataclass
class ProductEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("product_event_data",)

    product_event_data: ProductEventData

    id: EventId

    timestamp: datetime

    type: EventType
