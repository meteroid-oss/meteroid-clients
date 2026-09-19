# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel


@dataclasses.dataclass
class PatchPlanRequest(BaseModel):
    description: t.Optional[str] = None

    name: t.Optional[str] = None

    self_service_rank: t.Optional[int] = None
