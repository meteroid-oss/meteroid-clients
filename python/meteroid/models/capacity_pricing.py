# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class CapacityPricing(BaseModel):
    included: int

    overage_rate: Decimal

    rate: Decimal
