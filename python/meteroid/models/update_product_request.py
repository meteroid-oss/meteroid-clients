# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .product_fee_structure import ProductFeeStructure


@dataclasses.dataclass(kw_only=True)
class UpdateProductRequest(BaseModel):
    """The `UpdateProductRequest` object."""

    description: str | None | Unset = UNSET

    fee_structure: ProductFeeStructure | None | Unset = UNSET

    name: str | None | Unset = UNSET
