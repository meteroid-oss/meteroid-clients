# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId


@dataclasses.dataclass(kw_only=True)
class MeteredFeatureType(BaseModel):
    """The `MeteredFeatureType` object."""

    metric_id: BillableMetricId
