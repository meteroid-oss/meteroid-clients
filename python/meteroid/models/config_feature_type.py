# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .config_value_type import ConfigValueType


@dataclasses.dataclass(kw_only=True)
class ConfigFeatureType(BaseModel):
    """A static, typed configuration value. No metric — resolved synchronously."""

    value_type: ConfigValueType
    """The feature's value type, fixed at creation."""

    options: list[str] | None = None
    """Allowed values when `value_type = SELECT`. Empty otherwise."""
