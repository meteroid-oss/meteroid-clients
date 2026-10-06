# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .product_family_id import ProductFamilyId
    from .product_fee_structure import ProductFeeStructure
    from .product_fee_type_enum import ProductFeeTypeEnum
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class Product(BaseModel):
    """The `Product` object."""

    catalog: bool

    created_at: datetime

    fee_structure: ProductFeeStructure

    fee_type: ProductFeeTypeEnum

    id: ProductId

    name: str

    product_family_id: ProductFamilyId

    archived_at: datetime | None = None

    description: str | None = None
