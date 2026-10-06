# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .capacity_plan_fee import CapacityPlanFee
from .extra_recurring_plan_fee import ExtraRecurringPlanFee
from .one_time_plan_fee import OneTimePlanFee
from .rate_plan_fee import RatePlanFee
from .slot_plan_fee import SlotPlanFee
from .usage_plan_fee import UsagePlanFee

Fee: t.TypeAlias = t.Annotated[
    RatePlanFee
    | SlotPlanFee
    | CapacityPlanFee
    | UsagePlanFee
    | ExtraRecurringPlanFee
    | OneTimePlanFee
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "RATE": RatePlanFee,
            "SLOT": SlotPlanFee,
            "CAPACITY": CapacityPlanFee,
            "USAGE": UsagePlanFee,
            "EXTRA_RECURRING": ExtraRecurringPlanFee,
            "ONE_TIME": OneTimePlanFee,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
