# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .product_fee_structure import ProductFeeStructure
    from .product_fee_type_enum import ProductFeeTypeEnum


@dataclasses.dataclass(kw_only=True)
class NewProductRef(BaseModel):
    """The `NewProductRef` object."""

    fee_structure: ProductFeeStructure

    fee_type: ProductFeeTypeEnum

    name: str
