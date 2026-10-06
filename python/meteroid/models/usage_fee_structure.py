# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .usage_model_enum import UsageModelEnum


@dataclasses.dataclass(kw_only=True)
class UsageFeeStructure(BaseModel):
    """The `UsageFeeStructure` object."""

    metric_id: BillableMetricId

    model: UsageModelEnum
