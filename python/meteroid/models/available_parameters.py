# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass(kw_only=True)
class AvailableParameters(BaseModel):
    """The `AvailableParameters` object."""

    billing_periods: dict[str, list[BillingPeriodEnum]] | None = None
    """Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL")"""

    capacity_thresholds: dict[str, list[int]] | None = None
    """Map of component_id -> available capacity values"""

    slot_components: list[str] | None = None
    """List of component_ids that support slot parametrization (initial slot count)"""
