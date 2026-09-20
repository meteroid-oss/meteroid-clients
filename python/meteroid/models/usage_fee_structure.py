# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .usage_model_enum import UsageModelEnum


@dataclasses.dataclass
class UsageFeeStructure(BaseModel):
    metric_id: BillableMetricId

    model: UsageModelEnum
