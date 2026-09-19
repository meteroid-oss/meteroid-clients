# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId


@dataclasses.dataclass
class MeteredFeatureType(BaseModel):
    metric_id: BillableMetricId
