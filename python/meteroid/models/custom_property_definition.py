# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .custom_property_definition_id import CustomPropertyDefinitionId
    from .custom_property_entity_type import CustomPropertyEntityType
    from .custom_property_type import CustomPropertyType
    from .property_config import PropertyConfig


@dataclasses.dataclass(kw_only=True)
class CustomPropertyDefinition(BaseModel):
    """The `CustomPropertyDefinition` object."""

    archived: bool

    config: PropertyConfig

    display_order: int

    entity_type: CustomPropertyEntityType

    id: CustomPropertyDefinitionId

    key: str

    name: str

    property_type: CustomPropertyType

    required: bool

    default_value: t.Any = None

    description: str | None = None
