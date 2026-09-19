# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .plan_id import PlanId


@dataclasses.dataclass
class TrialConfig(BaseModel):
    duration_days: int

    is_free: bool

    trialing_plan_id: t.Optional[PlanId] = None
