# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .price_id import PriceId


@dataclasses.dataclass(kw_only=True)
class ExistingPriceRef(BaseModel):
    """The `ExistingPriceRef` object."""

    id: PriceId
