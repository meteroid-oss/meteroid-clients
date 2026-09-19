# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .plan_id import PlanId
from .plan_status_enum import PlanStatusEnum
from .plan_type_enum import PlanTypeEnum


@dataclasses.dataclass
class PlanEventData(BaseModel):
    created_at: datetime

    currency: str

    name: str

    plan_id: PlanId

    plan_type: PlanTypeEnum

    status: PlanStatusEnum

    version: int

    description: t.Optional[str] = None
