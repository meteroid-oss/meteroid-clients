# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .capacity_pricing import CapacityPricing
from .extra_recurring_pricing import ExtraRecurringPricing
from .one_time_pricing import OneTimePricing
from .rate_pricing import RatePricing
from .slot_pricing import SlotPricing
from .usage_pricing import UsagePricing

Pricing: t.TypeAlias = t.Annotated[
    RatePricing
    | SlotPricing
    | CapacityPricing
    | UsagePricing
    | ExtraRecurringPricing
    | OneTimePricing
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "RATE": RatePricing,
            "SLOT": SlotPricing,
            "CAPACITY": CapacityPricing,
            "USAGE": UsagePricing,
            "EXTRA_RECURRING": ExtraRecurringPricing,
            "ONE_TIME": OneTimePricing,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
