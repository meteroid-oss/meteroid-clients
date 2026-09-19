# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .feature import Feature
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class FeatureListResponse(BaseModel):
    data: t.List[Feature]

    pagination_meta: PaginationResponse
