# this file is @generated
from __future__ import annotations

import dataclasses
from datetime import datetime
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class MeteredEntitlementUsage(BaseModel):
    """The `MeteredEntitlementUsage` object."""

    consumed: Decimal | None = None

    remaining: Decimal | None = None

    reset_at: datetime | None = None
