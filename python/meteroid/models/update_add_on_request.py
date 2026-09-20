# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .price_id import PriceId


@dataclasses.dataclass
class UpdateAddOnRequest(BaseModel):
    description: t.Optional[str] = None

    max_instances_per_subscription: t.Optional[int] = None

    name: t.Optional[str] = None

    price_id: t.Optional[PriceId] = None

    self_serviceable: t.Optional[bool] = None
