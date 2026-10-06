# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass(kw_only=True)
class SubscriptionAddOnParameterization(BaseModel):
    """The `SubscriptionAddOnParameterization` object."""

    billing_period: BillingPeriodEnum | None | Unset = UNSET

    committed_capacity: int | None | Unset = UNSET

    initial_slot_count: int | None | Unset = UNSET
