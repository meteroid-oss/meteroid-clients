# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .reset_period import ResetPeriod


@dataclasses.dataclass(kw_only=True)
class MeteredEntitlementValue(BaseModel):
    """The `MeteredEntitlementValue` object."""

    enabled: bool | None = None
    """Per-entitlement kill switch. `false` means disabled."""

    limit: Decimal | None = None
    """Cap on usage. Null means unlimited."""

    reset_period: ResetPeriod | None = None
