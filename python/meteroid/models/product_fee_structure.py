# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .capacity_fee_structure import CapacityFeeStructure
from .extra_recurring_fee_structure import ExtraRecurringFeeStructure
from .one_time_fee_structure import OneTimeFeeStructure
from .rate_fee_structure import RateFeeStructure
from .slot_fee_structure import SlotFeeStructure
from .usage_fee_structure import UsageFeeStructure


@dataclasses.dataclass
class ProductFeeStructure(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "RATE": RateFeeStructure,
        "SLOT": SlotFeeStructure,
        "CAPACITY": CapacityFeeStructure,
        "USAGE": UsageFeeStructure,
        "EXTRA_RECURRING": ExtraRecurringFeeStructure,
        "ONE_TIME": OneTimeFeeStructure,
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
        RateFeeStructure,
        SlotFeeStructure,
        CapacityFeeStructure,
        UsageFeeStructure,
        ExtraRecurringFeeStructure,
        OneTimeFeeStructure,
    ]
