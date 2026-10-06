# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .event_id import EventId
    from .event_type import EventType
    from .product_event_data import ProductEventData


@dataclasses.dataclass(kw_only=True)
class ProductEvent(BaseModel):
    """The `ProductEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("product_event_data",)

    product_event_data: ProductEventData

    id: EventId

    timestamp: datetime

    type: EventType
