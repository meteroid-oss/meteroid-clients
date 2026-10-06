# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .pagination_response import PaginationResponse
    from .plan_version_summary import PlanVersionSummary


@dataclasses.dataclass(kw_only=True)
class PlanVersionListResponse(BaseModel):
    """The `PlanVersionListResponse` object."""

    data: list[PlanVersionSummary]

    pagination_meta: PaginationResponse
