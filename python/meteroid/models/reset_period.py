# this file is @generated
from __future__ import annotations

import typing as t

from ..serialization import Discriminator, UnknownVariant
from .billing_cycle_reset_period import BillingCycleResetPeriod
from .calendar_reset_period import CalendarResetPeriod
from .fixed_window_reset_period import FixedWindowResetPeriod
from .never_reset_period import NeverResetPeriod
from .sliding_window_reset_period import SlidingWindowResetPeriod

ResetPeriod: t.TypeAlias = t.Annotated[
    BillingCycleResetPeriod
    | CalendarResetPeriod
    | FixedWindowResetPeriod
    | SlidingWindowResetPeriod
    | NeverResetPeriod
    | UnknownVariant,
    Discriminator(
        "type",
        {
            "BILLING_CYCLE": BillingCycleResetPeriod,
            "CALENDAR": CalendarResetPeriod,
            "FIXED_WINDOW": FixedWindowResetPeriod,
            "SLIDING_WINDOW": SlidingWindowResetPeriod,
            "NEVER": NeverResetPeriod,
        },
    ),
]
"""Told apart by `type`; a variant this SDK version does not know is an `UnknownVariant`."""
