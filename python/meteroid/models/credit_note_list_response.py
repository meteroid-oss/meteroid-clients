# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .credit_note import CreditNote
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class CreditNoteListResponse(BaseModel):
    data: t.List[CreditNote]

    pagination_meta: PaginationResponse
