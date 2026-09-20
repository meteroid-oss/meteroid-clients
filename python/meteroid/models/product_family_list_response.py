# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .pagination_response import PaginationResponse
from .product_family import ProductFamily


@dataclasses.dataclass
class ProductFamilyListResponse(BaseModel):
    data: t.List[ProductFamily]

    pagination_meta: PaginationResponse
