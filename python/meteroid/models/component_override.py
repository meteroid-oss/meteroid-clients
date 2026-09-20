# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .price_component_id import PriceComponentId
from .price_entry import PriceEntry


@dataclasses.dataclass
class ComponentOverride(BaseModel):
    component_id: PriceComponentId

    name: str

    price_entry: PriceEntry
