# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class PaginationResponse(BaseModel):
    """The `PaginationResponse` object."""

    page: int

    per_page: int

    total_items: int

    total_pages: int
