# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .product_fee_structure import ProductFeeStructure
from .product_fee_type_enum import ProductFeeTypeEnum


@dataclasses.dataclass
class NewProductRef(BaseModel):
    fee_structure: ProductFeeStructure

    fee_type: ProductFeeTypeEnum

    name: str
