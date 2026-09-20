# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .customer import Customer
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class CustomerListResponse(BaseModel):
    data: t.List[Customer]

    pagination_meta: PaginationResponse
