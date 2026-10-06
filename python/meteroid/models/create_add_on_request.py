# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .price_id import PriceId
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class CreateAddOnRequest(BaseModel):
    """The `CreateAddOnRequest` object."""

    name: str

    price_id: PriceId

    product_id: ProductId

    description: str | None | Unset = UNSET

    max_instances_per_subscription: int | None | Unset = UNSET

    self_serviceable: bool | None = None
