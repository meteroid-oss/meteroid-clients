# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .component_parameters import ComponentParameters
    from .price_component_id import PriceComponentId


@dataclasses.dataclass(kw_only=True)
class ComponentParameterization(BaseModel):
    """The `ComponentParameterization` object."""

    component_id: PriceComponentId

    parameters: ComponentParameters
