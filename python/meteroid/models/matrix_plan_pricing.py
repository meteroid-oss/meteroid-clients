# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .matrix_row import MatrixRow


@dataclasses.dataclass(kw_only=True)
class MatrixPlanPricing(BaseModel):
    """The `MatrixPlanPricing` object."""

    rates: list[MatrixRow]
