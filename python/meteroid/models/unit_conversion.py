# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .unit_conversion_rounding_enum import UnitConversionRoundingEnum


@dataclasses.dataclass(kw_only=True)
class UnitConversion(BaseModel):
    """The `UnitConversion` object."""

    factor: int

    rounding: UnitConversionRoundingEnum
