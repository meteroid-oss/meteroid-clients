# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .metric_usage import MetricUsage


@dataclasses.dataclass(kw_only=True)
class UsageResponse(BaseModel):
    """The `UsageResponse` object."""

    period_end: date

    period_start: date

    usage: list[MetricUsage]
