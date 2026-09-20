# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .component_parameters import ComponentParameters
from .price_component_id import PriceComponentId


@dataclasses.dataclass
class ComponentParameterization(BaseModel):
    component_id: PriceComponentId

    parameters: ComponentParameters
