# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum
    from .billing_type import BillingType


@dataclasses.dataclass(kw_only=True)
class ExtraRecurringPlanFee(BaseModel):
    """Extra recurring fee"""

    billing_type: BillingType

    cadence: BillingPeriodEnum

    quantity: int

    unit_price: Decimal
