# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .price_id import PriceId


@dataclasses.dataclass
class ExistingPriceRef(BaseModel):
    id: PriceId
