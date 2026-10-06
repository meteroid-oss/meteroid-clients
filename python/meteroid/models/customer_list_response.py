# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer import Customer
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class CustomerListResponse(BaseModel):
    """The `CustomerListResponse` object."""

    data: list[Customer]

    pagination_meta: PaginationResponse
