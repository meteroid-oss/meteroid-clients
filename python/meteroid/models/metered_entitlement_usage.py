# this file is @generated
import dataclasses
import typing as t
from datetime import datetime
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class MeteredEntitlementUsage(BaseModel):
    consumed: t.Optional[Decimal] = None

    remaining: t.Optional[Decimal] = None

    reset_at: t.Optional[datetime] = None
