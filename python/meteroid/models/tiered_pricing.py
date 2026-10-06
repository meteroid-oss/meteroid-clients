# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .tier_row import TierRow


@dataclasses.dataclass(kw_only=True)
class TieredPricing(BaseModel):
    """The `TieredPricing` object."""

    tiers: list[TierRow]

    block_size: int | None | Unset = UNSET
