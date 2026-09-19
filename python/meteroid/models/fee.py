# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .capacity_plan_fee import CapacityPlanFee
from .extra_recurring_plan_fee import ExtraRecurringPlanFee
from .one_time_plan_fee import OneTimePlanFee
from .rate_plan_fee import RatePlanFee
from .slot_plan_fee import SlotPlanFee
from .usage_plan_fee import UsagePlanFee


@dataclasses.dataclass
class Fee(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "RATE": RatePlanFee,
        "SLOT": SlotPlanFee,
        "CAPACITY": CapacityPlanFee,
        "USAGE": UsagePlanFee,
        "EXTRA_RECURRING": ExtraRecurringPlanFee,
        "ONE_TIME": OneTimePlanFee,
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
        RatePlanFee,
        SlotPlanFee,
        CapacityPlanFee,
        UsagePlanFee,
        ExtraRecurringPlanFee,
        OneTimePlanFee,
    ]
