# this file is @generated
import dataclasses
from datetime import datetime

from ..serialization import BaseModel
from .plan_version_id import PlanVersionId


@dataclasses.dataclass
class PlanVersionSummary(BaseModel):
    created_at: datetime

    currency: str

    id: PlanVersionId

    is_draft: bool

    version: int
