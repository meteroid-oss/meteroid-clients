# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .billing_metric_aggregate_enum import BillingMetricAggregateEnum


@dataclasses.dataclass
class MetricSummary(BaseModel):
    aggregation_type: BillingMetricAggregateEnum

    code: str

    created_at: datetime

    id: BillableMetricId

    name: str

    aggregation_key: t.Optional[str] = None

    archived_at: t.Optional[datetime] = None

    description: t.Optional[str] = None
