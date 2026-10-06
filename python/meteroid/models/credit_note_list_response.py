# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .credit_note import CreditNote
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class CreditNoteListResponse(BaseModel):
    """The `CreditNoteListResponse` object."""

    data: list[CreditNote]

    pagination_meta: PaginationResponse
