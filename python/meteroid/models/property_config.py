# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .select_option import SelectOption


@dataclasses.dataclass
class PropertyConfig(BaseModel):
    """Type-specific configuration. Only the fields relevant to `property_type` are interpreted."""

    max: t.Optional[float] = None

    max_length: t.Optional[int] = None
    """Maximum length for `TEXT`."""

    min: t.Optional[float] = None
    """Inclusive numeric bounds for `NUMBER`."""

    options: t.Optional[t.List[SelectOption]] = None
    """Allowed choices for `SINGLE_SELECT` / `MULTI_SELECT`."""
