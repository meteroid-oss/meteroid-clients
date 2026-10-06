# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .add_on import AddOn
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class AddOnListResponse(BaseModel):
    """The `AddOnListResponse` object."""

    data: list[AddOn]

    pagination_meta: PaginationResponse
