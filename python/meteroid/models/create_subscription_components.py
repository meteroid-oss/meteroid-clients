# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .component_override import ComponentOverride
    from .component_parameterization import ComponentParameterization
    from .extra_component import ExtraComponent
    from .price_component_id import PriceComponentId


@dataclasses.dataclass(kw_only=True)
class CreateSubscriptionComponents(BaseModel):
    """The `CreateSubscriptionComponents` object."""

    extra_components: list[ExtraComponent] | None | Unset = UNSET

    overridden_components: list[ComponentOverride] | None | Unset = UNSET

    parameterized_components: list[ComponentParameterization] | None | Unset = UNSET

    remove_components: list[PriceComponentId] | None | Unset = UNSET
