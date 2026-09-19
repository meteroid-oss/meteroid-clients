# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .product_id import ProductId


@dataclasses.dataclass
class EntitlementProductRef(BaseModel):
    """Minimal reference to the product a feature belongs to."""

    id: ProductId

    name: str
