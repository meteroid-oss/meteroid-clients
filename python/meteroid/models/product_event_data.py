# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .product_family_id import ProductFamilyId
    from .product_fee_type_enum import ProductFeeTypeEnum
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class ProductEventData(BaseModel):
    """The `ProductEventData` object."""

    created_at: datetime

    fee_type: ProductFeeTypeEnum

    name: str

    product_family_id: ProductFamilyId

    product_id: ProductId

    description: str | None = None
