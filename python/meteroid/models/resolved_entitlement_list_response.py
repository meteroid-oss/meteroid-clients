# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .resolved_entitlement import ResolvedEntitlement


@dataclasses.dataclass(kw_only=True)
class ResolvedEntitlementListResponse(BaseModel):
    """The `ResolvedEntitlementListResponse` object."""

    data: list[ResolvedEntitlement]
