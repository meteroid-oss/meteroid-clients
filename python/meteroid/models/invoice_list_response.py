# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .invoice import Invoice
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class InvoiceListResponse(BaseModel):
    data: t.List[Invoice]

    pagination_meta: PaginationResponse
