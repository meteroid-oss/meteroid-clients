# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .price_entry import PriceEntry
from .product_ref import ProductRef


@dataclasses.dataclass
class ExtraComponent(BaseModel):
    name: str

    price_entry: PriceEntry

    product_ref: ProductRef
