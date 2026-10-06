# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .custom_property_definition import CustomPropertyDefinition
    from .pagination_response import PaginationResponse


@dataclasses.dataclass(kw_only=True)
class CustomPropertyDefinitionListResponse(BaseModel):
    """The `CustomPropertyDefinitionListResponse` object."""

    data: list[CustomPropertyDefinition]

    pagination_meta: PaginationResponse
