# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .metric_summary import MetricSummary
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class MetricListResponse(BaseModel):
    """The `MetricListResponse` object."""

    data: list[MetricSummary]

    pagination_meta: PaginationResponse
