# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .usage_pricing_model import UsagePricingModel


@dataclasses.dataclass(kw_only=True)
class UsageFee(BaseModel):
    """The `UsageFee` object."""

    metric_id: BillableMetricId

    model: UsagePricingModel
