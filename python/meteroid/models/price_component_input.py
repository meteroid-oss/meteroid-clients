# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .fee import Fee
from .product_id import ProductId


@dataclasses.dataclass
class PriceComponentInput(BaseModel):
    fee: Fee

    name: str

    product_id: t.Optional[ProductId] = None
