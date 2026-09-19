# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .custom_property_definition_id import CustomPropertyDefinitionId
from .custom_property_entity_type import CustomPropertyEntityType
from .custom_property_type import CustomPropertyType
from .property_config import PropertyConfig


@dataclasses.dataclass
class CustomPropertyDefinition(BaseModel):
    archived: bool

    config: PropertyConfig

    display_order: int

    entity_type: CustomPropertyEntityType

    id: CustomPropertyDefinitionId

    key: str

    name: str

    property_type: CustomPropertyType

    required: bool

    default_value: t.Optional[t.Any] = None

    description: t.Optional[str] = None
