# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .capacity_pricing import CapacityPricing
from .extra_recurring_pricing import ExtraRecurringPricing
from .one_time_pricing import OneTimePricing
from .rate_pricing import RatePricing
from .slot_pricing import SlotPricing
from .usage_pricing import UsagePricing


@dataclasses.dataclass
class Pricing(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "RATE": RatePricing,
        "SLOT": SlotPricing,
        "CAPACITY": CapacityPricing,
        "USAGE": UsagePricing,
        "EXTRA_RECURRING": ExtraRecurringPricing,
        "ONE_TIME": OneTimePricing,
    }

    type: t.Literal[
        "RATE",
        "SLOT",
        "CAPACITY",
        "USAGE",
        "EXTRA_RECURRING",
        "ONE_TIME",
    ]
    content: t.Union[
        RatePricing,
        SlotPricing,
        CapacityPricing,
        UsagePricing,
        ExtraRecurringPricing,
        OneTimePricing,
    ]
