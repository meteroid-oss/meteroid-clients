# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .price_id import PriceId
from .product_id import ProductId


@dataclasses.dataclass
class CreateAddOnRequest(BaseModel):
    name: str

    price_id: PriceId

    product_id: ProductId

    description: t.Optional[str] = None

    max_instances_per_subscription: t.Optional[int] = None

    self_serviceable: t.Optional[bool] = None
