# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class NeverResetPeriod(BaseModel):
    """Never resets — counts all usage since the subscription was activated."""
