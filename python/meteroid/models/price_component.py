# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .fee import Fee
    from .price_component_id import PriceComponentId
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class PriceComponent(BaseModel):
    """The `PriceComponent` object."""

    id: PriceComponentId

    name: str

    fee: Fee | None = None

    product_id: ProductId | None = None
