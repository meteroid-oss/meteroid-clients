# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_type_enum import BillingTypeEnum


@dataclasses.dataclass(kw_only=True)
class RecurringFee(BaseModel):
    """The `RecurringFee` object."""

    billing_type: BillingTypeEnum

    quantity: int

    rate: Decimal
