# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .plan_id import PlanId


@dataclasses.dataclass(kw_only=True)
class TrialConfig(BaseModel):
    """The `TrialConfig` object."""

    duration_days: int

    is_free: bool

    trialing_plan_id: PlanId | None | Unset = UNSET
