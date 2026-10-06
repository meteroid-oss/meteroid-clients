# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .config_value import ConfigValue


@dataclasses.dataclass(kw_only=True)
class ConfigEffectiveEntitlementValue(BaseModel):
    """The `ConfigEffectiveEntitlementValue` object."""

    value: ConfigValue
