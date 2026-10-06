# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .metric_dimension import MetricDimension


@dataclasses.dataclass(kw_only=True)
class DoubleSegmentationMatrix(BaseModel):
    """The `DoubleSegmentationMatrix` object."""

    dimension1: MetricDimension

    dimension2: MetricDimension
