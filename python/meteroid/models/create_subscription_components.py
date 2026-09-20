# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .component_override import ComponentOverride
from .component_parameterization import ComponentParameterization
from .extra_component import ExtraComponent
from .price_component_id import PriceComponentId


@dataclasses.dataclass
class CreateSubscriptionComponents(BaseModel):
    extra_components: t.Optional[t.List[ExtraComponent]] = None

    overridden_components: t.Optional[t.List[ComponentOverride]] = None

    parameterized_components: t.Optional[t.List[ComponentParameterization]] = None

    remove_components: t.Optional[t.List[PriceComponentId]] = None
