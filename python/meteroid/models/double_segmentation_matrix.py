# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .metric_dimension import MetricDimension


@dataclasses.dataclass
class DoubleSegmentationMatrix(BaseModel):
    dimension1: MetricDimension

    dimension2: MetricDimension
