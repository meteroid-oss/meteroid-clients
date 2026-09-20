# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .add_on import AddOn
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class AddOnListResponse(BaseModel):
    data: t.List[AddOn]

    pagination_meta: PaginationResponse
