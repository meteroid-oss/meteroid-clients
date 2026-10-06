# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .capacity_fee_structure import CapacityFeeStructure
from .extra_recurring_fee_structure import ExtraRecurringFeeStructure
from .one_time_fee_structure import OneTimeFeeStructure
from .rate_fee_structure import RateFeeStructure
from .slot_fee_structure import SlotFeeStructure
from .usage_fee_structure import UsageFeeStructure

ProductFeeStructure: t.TypeAlias = t.Annotated[
    RateFeeStructure
    | SlotFeeStructure
    | CapacityFeeStructure
    | UsageFeeStructure
    | ExtraRecurringFeeStructure
    | OneTimeFeeStructure
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "RATE": RateFeeStructure,
            "SLOT": SlotFeeStructure,
            "CAPACITY": CapacityFeeStructure,
            "USAGE": UsageFeeStructure,
            "EXTRA_RECURRING": ExtraRecurringFeeStructure,
            "ONE_TIME": OneTimeFeeStructure,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
