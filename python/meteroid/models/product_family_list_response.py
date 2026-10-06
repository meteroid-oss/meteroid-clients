# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .pagination_response import PaginationResponse
    from .product_family import ProductFamily


@dataclasses.dataclass(kw_only=True)
class ProductFamilyListResponse(BaseModel):
    """The `ProductFamilyListResponse` object."""

    data: list[ProductFamily]

    pagination_meta: PaginationResponse
