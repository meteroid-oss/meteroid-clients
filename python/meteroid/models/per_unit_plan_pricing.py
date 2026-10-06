# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class PerUnitPlanPricing(BaseModel):
    """The `PerUnitPlanPricing` object."""

    rate: Decimal
