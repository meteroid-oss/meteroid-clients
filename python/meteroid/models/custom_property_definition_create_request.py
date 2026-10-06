# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .custom_property_entity_type import CustomPropertyEntityType
    from .custom_property_type import CustomPropertyType
    from .property_config import PropertyConfig


@dataclasses.dataclass(kw_only=True)
class CustomPropertyDefinitionCreateRequest(BaseModel):
    """The `CustomPropertyDefinitionCreateRequest` object."""

    entity_type: CustomPropertyEntityType

    key: str
    """Immutable machine name; letters, digits and underscores only. Unique per entity type."""

    name: str

    property_type: CustomPropertyType

    config: PropertyConfig | None = None

    default_value: t.Any = None

    description: str | None | Unset = UNSET

    display_order: int | None = None

    required: bool | None = None
