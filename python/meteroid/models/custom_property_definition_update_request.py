# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .property_config import PropertyConfig


@dataclasses.dataclass(kw_only=True)
class CustomPropertyDefinitionUpdateRequest(BaseModel):
    """Update of a definition. `key`, `entity_type` and `property_type` are immutable and cannot be
    changed here. Any field left absent is unchanged."""

    config: PropertyConfig | None | Unset = UNSET

    default_value: t.Any = None

    description: str | None | Unset = UNSET

    display_order: int | None | Unset = UNSET

    name: str | None | Unset = UNSET

    required: bool | None | Unset = UNSET
