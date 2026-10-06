# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .price_entry import PriceEntry
    from .product_ref import ProductRef


@dataclasses.dataclass(kw_only=True)
class ExtraComponent(BaseModel):
    """The `ExtraComponent` object."""

    name: str

    price_entry: PriceEntry

    product_ref: ProductRef
