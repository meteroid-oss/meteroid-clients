# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .metric_filter_operator import MetricFilterOperator


@dataclasses.dataclass(kw_only=True)
class MetricFilter(BaseModel):
    """A pre-aggregation filter: only events whose `property` matches feed the metric's
    aggregation. Distinct from a segmentation dimension (which splits pricing). Multiple
    filters are ANDed."""

    op: MetricFilterOperator

    property: str

    values: list[str]
