# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .product_family_id import ProductFamilyId


@dataclasses.dataclass(kw_only=True)
class ProductFamily(BaseModel):
    """The `ProductFamily` object."""

    id: ProductFamilyId

    name: str
