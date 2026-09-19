# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .metric_usage import MetricUsage


@dataclasses.dataclass
class UsageResponse(BaseModel):
    period_end: str

    period_start: str

    usage: t.List[MetricUsage]
