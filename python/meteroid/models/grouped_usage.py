# this file is @generated
import dataclasses
import typing as t
from decimal import Decimal

from ..serialization import BaseModel


@dataclasses.dataclass
class GroupedUsage(BaseModel):
    dimensions: t.Dict[str, str]

    value: Decimal
