# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .product_id import ProductId


@dataclasses.dataclass
class ExistingProductRef(BaseModel):
    id: ProductId
