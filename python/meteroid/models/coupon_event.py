# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .coupon_event_data import CouponEventData
from .event_id import EventId
from .event_type import EventType


@dataclasses.dataclass
class CouponEvent(BaseModel):
    _FLATTENED: t.ClassVar[t.Tuple[str, ...]] = ("coupon_event_data",)

    coupon_event_data: CouponEventData

    id: EventId

    timestamp: datetime

    type: EventType
