# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .invoice import Invoice
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class InvoiceListResponse(BaseModel):
    """The `InvoiceListResponse` object."""

    data: list[Invoice]

    pagination_meta: PaginationResponse
