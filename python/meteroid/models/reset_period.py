# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel, TaggedUnionModel
from .billing_cycle_reset_period import BillingCycleResetPeriod
from .calendar_reset_period import CalendarResetPeriod
from .fixed_window_reset_period import FixedWindowResetPeriod
from .never_reset_period import NeverResetPeriod
from .sliding_window_reset_period import SlidingWindowResetPeriod


@dataclasses.dataclass
class ResetPeriod(TaggedUnionModel):
    _DISCRIMINATOR: t.ClassVar[str] = "type"
    _DISCRIMINATOR_ATTR: t.ClassVar[str] = "type"
    _CONTENT_ATTR: t.ClassVar[str] = "content"
    _CONTENT_KEY: t.ClassVar[t.Optional[str]] = None
    _VARIANTS: t.ClassVar[t.Mapping[str, t.Optional[t.Type[BaseModel]]]] = {
        "BILLING_CYCLE": BillingCycleResetPeriod,
        "CALENDAR": CalendarResetPeriod,
        "FIXED_WINDOW": FixedWindowResetPeriod,
        "SLIDING_WINDOW": SlidingWindowResetPeriod,
        "NEVER": NeverResetPeriod,
    }

    type: t.Literal[
        "BILLING_CYCLE",
        "CALENDAR",
        "FIXED_WINDOW",
        "SLIDING_WINDOW",
        "NEVER",
    ]
    content: t.Union[
        BillingCycleResetPeriod,
        CalendarResetPeriod,
        FixedWindowResetPeriod,
        SlidingWindowResetPeriod,
        NeverResetPeriod,
    ]
