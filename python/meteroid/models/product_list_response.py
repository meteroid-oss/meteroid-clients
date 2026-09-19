# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .pagination_response import PaginationResponse
from .product import Product


@dataclasses.dataclass
class ProductListResponse(BaseModel):
    data: t.List[Product]

    pagination_meta: PaginationResponse
