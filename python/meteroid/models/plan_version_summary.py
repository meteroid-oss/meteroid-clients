# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .plan_version_id import PlanVersionId


@dataclasses.dataclass(kw_only=True)
class PlanVersionSummary(BaseModel):
    """The `PlanVersionSummary` object."""

    created_at: datetime

    currency: str

    id: PlanVersionId

    is_draft: bool

    version: int
