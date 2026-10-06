# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .pagination_response import PaginationResponse
    from .plan import Plan


@dataclasses.dataclass(kw_only=True)
class PlanListResponse(BaseModel):
    """The `PlanListResponse` object."""

    data: list[Plan]

    pagination_meta: PaginationResponse
