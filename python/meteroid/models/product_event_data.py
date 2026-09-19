# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .product_family_id import ProductFamilyId
from .product_fee_type_enum import ProductFeeTypeEnum
from .product_id import ProductId


@dataclasses.dataclass
class ProductEventData(BaseModel):
    created_at: datetime

    fee_type: ProductFeeTypeEnum

    name: str

    product_family_id: ProductFamilyId

    product_id: ProductId

    description: t.Optional[str] = None
