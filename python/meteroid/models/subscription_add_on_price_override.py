# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .price_entry import PriceEntry


@dataclasses.dataclass
class SubscriptionAddOnPriceOverride(BaseModel):
    price_entry: PriceEntry

    name: t.Optional[str] = None
