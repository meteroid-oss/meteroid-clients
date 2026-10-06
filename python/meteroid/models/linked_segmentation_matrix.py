# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class LinkedSegmentationMatrix(BaseModel):
    """The `LinkedSegmentationMatrix` object."""

    dimension1_key: str

    dimension2_key: str

    values: dict[str, list[str]]
