# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .fee import Fee
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class PriceComponentInput(BaseModel):
    """The `PriceComponentInput` object."""

    fee: Fee

    name: str

    product_id: ProductId | None | Unset = UNSET
