# this file is @generated
import dataclasses

from ..serialization import BaseModel
from .unit_conversion_rounding_enum import UnitConversionRoundingEnum


@dataclasses.dataclass
class UnitConversion(BaseModel):
    factor: int

    rounding: UnitConversionRoundingEnum
