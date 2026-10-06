# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum
    from .pricing import Pricing


@dataclasses.dataclass(kw_only=True)
class PriceInput(BaseModel):
    """The `PriceInput` object."""

    cadence: BillingPeriodEnum

    currency: str

    pricing: Pricing
