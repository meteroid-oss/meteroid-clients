# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .billing_period_enum import BillingPeriodEnum


@dataclasses.dataclass
class AvailableParameters(BaseModel):
    billing_periods: t.Optional[t.Dict[str, t.List[BillingPeriodEnum]]] = None
    """Map of component_id -> available billing periods (e.g., "MONTHLY", "ANNUAL")"""

    capacity_thresholds: t.Optional[t.Dict[str, t.List[int]]] = None
    """Map of component_id -> available capacity values"""

    slot_components: t.Optional[t.List[str]] = None
    """List of component_ids that support slot parametrization (initial slot count)"""
