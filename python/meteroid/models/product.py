# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .product_family_id import ProductFamilyId
from .product_fee_structure import ProductFeeStructure
from .product_fee_type_enum import ProductFeeTypeEnum
from .product_id import ProductId


@dataclasses.dataclass
class Product(BaseModel):
    catalog: bool

    created_at: datetime

    fee_structure: ProductFeeStructure

    fee_type: ProductFeeTypeEnum

    id: ProductId

    name: str

    product_family_id: ProductFamilyId

    archived_at: t.Optional[datetime] = None

    description: t.Optional[str] = None
