# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .product_family_id import ProductFamilyId
    from .product_fee_structure import ProductFeeStructure


@dataclasses.dataclass(kw_only=True)
class CreateProductRequest(BaseModel):
    """The `CreateProductRequest` object."""

    fee_structure: ProductFeeStructure

    name: str

    product_family_id: ProductFamilyId

    catalog: bool | None = None

    description: str | None | Unset = UNSET
