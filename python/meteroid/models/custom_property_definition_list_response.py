# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .custom_property_definition import CustomPropertyDefinition
from .pagination_response import PaginationResponse


@dataclasses.dataclass
class CustomPropertyDefinitionListResponse(BaseModel):
    data: t.List[CustomPropertyDefinition]

    pagination_meta: PaginationResponse
