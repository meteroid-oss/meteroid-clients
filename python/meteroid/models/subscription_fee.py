# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .capacity_fee import CapacityFee
from .one_time_fee import OneTimeFee
from .rate_fee import RateFee
from .recurring_fee import RecurringFee
from .slot_fee import SlotFee
from .usage_fee import UsageFee

SubscriptionFee: t.TypeAlias = t.Annotated[
    RateFee
    | OneTimeFee
    | RecurringFee
    | CapacityFee
    | SlotFee
    | UsageFee
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "RATE": RateFee,
            "ONE_TIME": OneTimeFee,
            "RECURRING": RecurringFee,
            "CAPACITY": CapacityFee,
            "SLOT": SlotFee,
            "USAGE": UsageFee,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
