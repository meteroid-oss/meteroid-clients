# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .resolved_entitlement import ResolvedEntitlement


@dataclasses.dataclass
class ResolvedEntitlementListResponse(BaseModel):
    data: t.List[ResolvedEntitlement]
