# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import UNSET, BaseModel, Unset


@dataclasses.dataclass(kw_only=True)
class PatchPlanRequest(BaseModel):
    """The `PatchPlanRequest` object."""

    description: str | None | Unset = UNSET

    name: str | None | Unset = UNSET

    self_service_rank: int | None | Unset = UNSET
