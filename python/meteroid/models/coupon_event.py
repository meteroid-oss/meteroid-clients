# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .coupon_event_data import CouponEventData
    from .event_id import EventId
    from .event_type import EventType


@dataclasses.dataclass(kw_only=True)
class CouponEvent(BaseModel):
    """The `CouponEvent` object."""

    _FLATTENED: t.ClassVar[tuple[str, ...]] = ("coupon_event_data",)

    coupon_event_data: CouponEventData

    id: EventId

    timestamp: datetime

    type: EventType
