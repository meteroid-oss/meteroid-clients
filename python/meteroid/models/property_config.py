# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .select_option import SelectOption


@dataclasses.dataclass(kw_only=True)
class PropertyConfig(BaseModel):
    """Type-specific configuration. Only the fields relevant to `property_type` are interpreted."""

    max: float | None | Unset = UNSET

    max_length: int | None | Unset = UNSET
    """Maximum length for `TEXT`."""

    min: float | None | Unset = UNSET
    """Inclusive numeric bounds for `NUMBER`."""

    options: list[SelectOption] | None | Unset = UNSET
    """Allowed choices for `SINGLE_SELECT` / `MULTI_SELECT`."""
