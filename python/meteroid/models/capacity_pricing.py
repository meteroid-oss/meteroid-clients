# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class CapacityPricing(BaseModel):
    """The `CapacityPricing` object."""

    included: int

    overage_rate: Decimal

    rate: Decimal
