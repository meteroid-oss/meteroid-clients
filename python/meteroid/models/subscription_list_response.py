# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .pagination_response import PaginationResponse
    from .subscription import Subscription


@dataclasses.dataclass(kw_only=True)
class SubscriptionListResponse(BaseModel):
    """The `SubscriptionListResponse` object."""

    data: list[Subscription]

    pagination_meta: PaginationResponse
