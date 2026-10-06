# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class BillingCycleResetPeriod(BaseModel):
    """Resets each time your subscription renews — anchored to your billing cycle."""
