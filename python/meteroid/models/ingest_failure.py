# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class IngestFailure(BaseModel):
    """The `IngestFailure` object."""

    event_id: str

    reason: str
