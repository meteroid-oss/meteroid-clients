# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class PaginationResponse(BaseModel):
    page: int

    per_page: int

    total_items: int

    total_pages: int
