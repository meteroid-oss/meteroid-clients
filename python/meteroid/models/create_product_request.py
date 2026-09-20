# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .product_family_id import ProductFamilyId
from .product_fee_structure import ProductFeeStructure


@dataclasses.dataclass
class CreateProductRequest(BaseModel):
    fee_structure: ProductFeeStructure

    name: str

    product_family_id: ProductFamilyId

    catalog: t.Optional[bool] = None

    description: t.Optional[str] = None
