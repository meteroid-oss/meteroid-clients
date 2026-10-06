# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass(kw_only=True)
class TermRate(BaseModel):
    """The `TermRate` object."""

    price: Decimal

    term: BillingPeriodEnum
