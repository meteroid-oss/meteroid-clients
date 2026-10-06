# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .plan_id import PlanId
    from .plan_status_enum import PlanStatusEnum
    from .plan_type_enum import PlanTypeEnum


@dataclasses.dataclass(kw_only=True)
class PlanEventData(BaseModel):
    """The `PlanEventData` object."""

    created_at: datetime

    currency: str

    name: str

    plan_id: PlanId

    plan_type: PlanTypeEnum

    status: PlanStatusEnum

    version: int

    description: str | None = None
