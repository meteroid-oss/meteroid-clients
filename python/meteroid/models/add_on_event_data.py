# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .add_on_id import AddOnId
from .price_id import PriceId
from .product_fee_type_enum import ProductFeeTypeEnum
from .product_id import ProductId


@dataclasses.dataclass
class AddOnEventData(BaseModel):
    add_on_id: AddOnId

    created_at: datetime

    name: str

    price_id: PriceId

    product_id: ProductId

    self_serviceable: bool

    description: t.Optional[str] = None

    fee_type: t.Optional[ProductFeeTypeEnum] = None

    max_instances_per_subscription: t.Optional[int] = None
