# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class ProductsScope(BaseModel):
    """Only lines for the listed products count. A product is the identity shared by plan
    components, overrides and ad-hoc extras, so a subscription's billed set is matched uniformly."""

    product_ids: list[str]
