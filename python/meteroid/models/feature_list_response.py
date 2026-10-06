# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .feature import Feature
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class FeatureListResponse(BaseModel):
    """The `FeatureListResponse` object."""

    data: list[Feature]

    pagination_meta: PaginationResponse
