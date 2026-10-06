# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .metric_filter import MetricFilter
    from .metric_segmentation_matrix import MetricSegmentationMatrix
    from .unit_conversion import UnitConversion


@dataclasses.dataclass(kw_only=True)
class UpdateMetricRequest(BaseModel):
    """The `UpdateMetricRequest` object."""

    description: str | None | Unset = UNSET

    filters: list[MetricFilter] | None | Unset = UNSET
    """Absent = leave filters untouched; present (even empty) = replace them."""

    name: str | None | Unset = UNSET

    segmentation_matrix: MetricSegmentationMatrix | None | Unset = UNSET

    unit_conversion: UnitConversion | None | Unset = UNSET
