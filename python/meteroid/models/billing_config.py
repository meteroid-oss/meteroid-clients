# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class BillingConfig(BaseModel):
    """The `BillingConfig` object."""

    billing_cycles: int | None | Unset = UNSET

    net_terms: int | None = None

    period_start_day: int | None | Unset = UNSET
