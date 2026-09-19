# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .metric_filter import MetricFilter
from .metric_segmentation_matrix import MetricSegmentationMatrix
from .unit_conversion import UnitConversion


@dataclasses.dataclass
class UpdateMetricRequest(BaseModel):
    description: t.Optional[str] = None

    filters: t.Optional[t.List[MetricFilter]] = None
    """Absent = leave filters untouched; present (even empty) = replace them."""

    name: t.Optional[str] = None

    segmentation_matrix: t.Optional[MetricSegmentationMatrix] = None

    unit_conversion: t.Optional[UnitConversion] = None
