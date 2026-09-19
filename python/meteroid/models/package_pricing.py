# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class PackagePricing(BaseModel):
    block_size: int

    rate: Decimal
