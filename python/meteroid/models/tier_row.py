# this file is @generated
from __future__ import annotations

import dataclasses
from decimal import Decimal

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class TierRow(BaseModel):
    """The `TierRow` object."""

    first_unit: int

    rate: Decimal

    flat_cap: Decimal | None | Unset = UNSET

    flat_fee: Decimal | None | Unset = UNSET
