# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .custom_property_entity_type import CustomPropertyEntityType
from .custom_property_type import CustomPropertyType
from .property_config import PropertyConfig


@dataclasses.dataclass
class CustomPropertyDefinitionCreateRequest(BaseModel):
    entity_type: CustomPropertyEntityType

    key: str
    """Immutable machine name; letters, digits and underscores only. Unique per entity type."""

    name: str

    property_type: CustomPropertyType

    config: t.Optional[PropertyConfig] = None

    default_value: t.Optional[t.Any] = None

    description: t.Optional[str] = None

    display_order: t.Optional[int] = None

    required: t.Optional[bool] = None
