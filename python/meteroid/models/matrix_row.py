# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import UNSET, BaseModel, Unset

if t.TYPE_CHECKING:
    from .matrix_dimension import MatrixDimension


@dataclasses.dataclass(kw_only=True)
class MatrixRow(BaseModel):
    """The `MatrixRow` object."""

    dimension1: MatrixDimension

    per_unit_price: Decimal

    dimension2: MatrixDimension | None | Unset = UNSET
