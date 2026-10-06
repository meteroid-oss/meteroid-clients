# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .add_on_id import AddOnId
    from .price_id import PriceId


@dataclasses.dataclass(kw_only=True)
class PlanAddOnInput(BaseModel):
    """The `PlanAddOnInput` object."""

    add_on_id: AddOnId

    max_instances: int | None | Unset = UNSET

    price_id: PriceId | None | Unset = UNSET

    self_serviceable: bool | None | Unset = UNSET
