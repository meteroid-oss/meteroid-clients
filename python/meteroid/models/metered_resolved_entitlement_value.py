# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .billable_metric_id import BillableMetricId
from .reset_period import ResetPeriod


@dataclasses.dataclass
class MeteredResolvedEntitlementValue(BaseModel):
    enabled: bool

    metric_id: BillableMetricId

    reset_period: ResetPeriod

    limit: t.Optional[Decimal] = None
