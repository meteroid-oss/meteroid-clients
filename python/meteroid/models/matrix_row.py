# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel
from .matrix_dimension import MatrixDimension


@dataclasses.dataclass
class MatrixRow(BaseModel):
    dimension1: MatrixDimension

    per_unit_price: Decimal

    dimension2: t.Optional[MatrixDimension] = None
