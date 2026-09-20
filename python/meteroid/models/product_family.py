# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .product_family_id import ProductFamilyId


@dataclasses.dataclass
class ProductFamily(BaseModel):
    id: ProductFamilyId

    name: str
