# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .reset_period import ResetPeriod


@dataclasses.dataclass
class MeteredEntitlementValue(BaseModel):
    enabled: t.Optional[bool] = None
    """Per-entitlement kill switch. `false` means disabled."""

    limit: t.Optional[Decimal] = None
    """Cap on usage. Null means unlimited."""

    reset_period: t.Optional[ResetPeriod] = None
