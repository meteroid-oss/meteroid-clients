# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class MetricDimension(BaseModel):
    """The `MetricDimension` object."""

    key: str

    values: list[str]
