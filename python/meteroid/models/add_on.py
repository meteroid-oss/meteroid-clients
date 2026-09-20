# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .add_on_id import AddOnId
from .entitlement import Entitlement
from .price_id import PriceId
from .product_fee_type_enum import ProductFeeTypeEnum
from .product_id import ProductId


@dataclasses.dataclass
class AddOn(BaseModel):
    created_at: datetime

    id: AddOnId

    name: str

    price_id: PriceId

    product_id: ProductId

    self_serviceable: bool

    archived_at: t.Optional[datetime] = None

    description: t.Optional[str] = None

    entitlements: t.Optional[t.List[Entitlement]] = None

    fee_type: t.Optional[ProductFeeTypeEnum] = None

    max_instances_per_subscription: t.Optional[int] = None
