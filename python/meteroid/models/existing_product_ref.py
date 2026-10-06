# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .product_id import ProductId


@dataclasses.dataclass(kw_only=True)
class ExistingProductRef(BaseModel):
    """The `ExistingProductRef` object."""

    id: ProductId
