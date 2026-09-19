# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .metric_filter_operator import MetricFilterOperator


@dataclasses.dataclass
class MetricFilter(BaseModel):
    """A pre-aggregation filter: only events whose `property` matches feed the metric's
    aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple
    filters are ANDed."""

    op: MetricFilterOperator

    property: str

    values: t.List[str]
