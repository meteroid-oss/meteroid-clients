# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billable_metric_id import BillableMetricId
    from .reset_period import ResetPeriod


@dataclasses.dataclass(kw_only=True)
class MeteredEntitlementSpec(BaseModel):
    """The `MeteredEntitlementSpec` object."""

    enabled: bool

    metric_id: BillableMetricId

    reset_period: ResetPeriod

    limit: Decimal | None = None
