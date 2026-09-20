# this file is @generated
import dataclasses
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class NumberConfigValue(BaseModel):
    """A number config value (decimal, encoded as a string)."""

    value: Decimal
