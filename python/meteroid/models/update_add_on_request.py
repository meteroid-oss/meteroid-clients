# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .price_id import PriceId


@dataclasses.dataclass(kw_only=True)
class UpdateAddOnRequest(BaseModel):
    """The `UpdateAddOnRequest` object."""

    description: str | None | Unset = UNSET

    max_instances_per_subscription: int | None | Unset = UNSET

    name: str | None | Unset = UNSET

    price_id: PriceId | None | Unset = UNSET

    self_serviceable: bool | None | Unset = UNSET
