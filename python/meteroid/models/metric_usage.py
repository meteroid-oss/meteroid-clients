# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .grouped_usage import GroupedUsage


@dataclasses.dataclass
class MetricUsage(BaseModel):
    grouped_usage: t.List[GroupedUsage]

    metric_code: str

    metric_id: BillableMetricId

    metric_name: str

    total_value: Decimal
