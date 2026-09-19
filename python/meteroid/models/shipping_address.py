# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .address import Address


@dataclasses.dataclass
class ShippingAddress(BaseModel):
    same_as_billing: bool

    address: t.Optional[Address] = None
