# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .pagination_response import PaginationResponse
    from .product import Product


@dataclasses.dataclass(kw_only=True)
class ProductListResponse(BaseModel):
    """The `ProductListResponse` object."""

    data: list[Product]

    pagination_meta: PaginationResponse
