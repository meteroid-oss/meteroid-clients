# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .capacity_fee import CapacityFee
from .one_time_fee import OneTimeFee
from .rate_fee import RateFee
from .recurring_fee import RecurringFee
from .slot_fee import SlotFee
from .usage_fee import UsageFee


@dataclasses.dataclass
class SubscriptionFee(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "RATE": RateFee,
        "ONE_TIME": OneTimeFee,
        "RECURRING": RecurringFee,
        "CAPACITY": CapacityFee,
        "SLOT": SlotFee,
        "USAGE": UsageFee,
    }

    type: t.Literal[
        "RATE",
        "ONE_TIME",
        "RECURRING",
        "CAPACITY",
        "SLOT",
        "USAGE",
    ]
    content: t.Union[
        RateFee,
        OneTimeFee,
        RecurringFee,
        CapacityFee,
        SlotFee,
        UsageFee,
    ]
