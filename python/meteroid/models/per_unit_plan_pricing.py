# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class PerUnitPlanPricing(BaseModel):
    rate: Decimal
