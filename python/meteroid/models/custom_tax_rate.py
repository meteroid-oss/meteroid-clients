# this file is @generated
from __future__ import annotations

import dataclasses

from ..serialization import BaseModel


@dataclasses.dataclass(kw_only=True)
class CustomTaxRate(BaseModel):
    """The `CustomTaxRate` object."""

    name: str

    rate: str

    tax_code: str
