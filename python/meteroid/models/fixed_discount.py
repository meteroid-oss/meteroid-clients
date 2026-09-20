# this file is @generated
import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass
class FixedDiscount(BaseModel):
    amount: str

    currency: str
