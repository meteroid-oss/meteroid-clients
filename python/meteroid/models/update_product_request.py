# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .product_fee_structure import ProductFeeStructure


@dataclasses.dataclass
class UpdateProductRequest(BaseModel):
    description: t.Optional[str] = None

    fee_structure: t.Optional[ProductFeeStructure] = None

    name: t.Optional[str] = None
