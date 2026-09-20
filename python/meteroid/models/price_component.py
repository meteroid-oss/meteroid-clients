# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .fee import Fee
from .price_component_id import PriceComponentId
from .product_id import ProductId


@dataclasses.dataclass
class PriceComponent(BaseModel):
    id: PriceComponentId

    name: str

    fee: t.Optional[Fee] = None

    product_id: t.Optional[ProductId] = None
