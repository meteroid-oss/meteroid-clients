# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .matrix_row import MatrixRow


@dataclasses.dataclass
class MatrixPlanPricing(BaseModel):
    rates: t.List[MatrixRow]
