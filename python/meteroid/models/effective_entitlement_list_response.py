# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .effective_entitlement import EffectiveEntitlement


@dataclasses.dataclass
class EffectiveEntitlementListResponse(BaseModel):
    data: t.List[EffectiveEntitlement]
