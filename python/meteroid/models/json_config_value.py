# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class JsonConfigValue(BaseModel):
    """A structured (JSON) config value — the "metadata" case, several fields in one entitlement."""

    value: t.Any
