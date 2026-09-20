# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .add_on_id import AddOnId
from .price_id import PriceId


@dataclasses.dataclass
class PlanAddOnInput(BaseModel):
    add_on_id: AddOnId

    max_instances: t.Optional[int] = None

    price_id: t.Optional[PriceId] = None

    self_serviceable: t.Optional[bool] = None
