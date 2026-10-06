# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class SelectOption(BaseModel):
    """The `SelectOption` object."""

    value: str

    label: str | None | Unset = UNSET
