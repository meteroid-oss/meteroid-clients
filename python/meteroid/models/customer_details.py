# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .address import Address
from .customer_id import CustomerId


@dataclasses.dataclass
class CustomerDetails(BaseModel):
    id: CustomerId

    name: str

    snapshot_at: datetime

    alias: t.Optional[str] = None

    billing_address: t.Optional[Address] = None

    email: t.Optional[str] = None

    vat_number: t.Optional[str] = None
