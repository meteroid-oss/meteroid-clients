# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .add_on_id import AddOnId
    from .price_id import PriceId
    from .product_fee_type_enum import ProductFeeTypeEnum
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class AddOnEventData(BaseModel):
    """The `AddOnEventData` object."""

    add_on_id: AddOnId

    created_at: datetime

    name: str

    price_id: PriceId

    product_id: ProductId

    self_serviceable: bool

    description: str | None = None

    fee_type: ProductFeeTypeEnum | None = None

    max_instances_per_subscription: int | None = None
