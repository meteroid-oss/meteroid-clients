# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .address import Address


@dataclasses.dataclass(kw_only=True)
class ShippingAddress(BaseModel):
    """The `ShippingAddress` object."""

    same_as_billing: bool

    address: Address | None | Unset = UNSET
