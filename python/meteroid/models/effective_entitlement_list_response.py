# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .effective_entitlement import EffectiveEntitlement


@dataclasses.dataclass(kw_only=True)
class EffectiveEntitlementListResponse(BaseModel):
    """The `EffectiveEntitlementListResponse` object."""

    data: list[EffectiveEntitlement]
