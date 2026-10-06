# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class FixedDiscount(BaseModel):
    """The `FixedDiscount` object."""

    amount: str

    currency: str
