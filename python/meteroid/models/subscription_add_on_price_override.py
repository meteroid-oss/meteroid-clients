# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .price_entry import PriceEntry


@dataclasses.dataclass(kw_only=True)
class SubscriptionAddOnPriceOverride(BaseModel):
    """The `SubscriptionAddOnPriceOverride` object."""

    price_entry: PriceEntry

    name: str | None | Unset = UNSET
