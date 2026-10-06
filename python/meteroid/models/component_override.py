# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .price_component_id import PriceComponentId
    from .price_entry import PriceEntry


@dataclasses.dataclass(kw_only=True)
class ComponentOverride(BaseModel):
    """The `ComponentOverride` object."""

    component_id: PriceComponentId

    name: str

    price_entry: PriceEntry
