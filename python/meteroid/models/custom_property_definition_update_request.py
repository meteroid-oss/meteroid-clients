# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .property_config import PropertyConfig


@dataclasses.dataclass
class CustomPropertyDefinitionUpdateRequest(BaseModel):
    """Update of a definition. `key`, `entity_type` and `property_type` are immutable and cannot be
    changed here. Any field left absent is unchanged."""

    config: t.Optional[PropertyConfig] = None

    default_value: t.Optional[t.Any] = None

    description: t.Optional[str] = None

    display_order: t.Optional[int] = None

    name: t.Optional[str] = None

    required: t.Optional[bool] = None
