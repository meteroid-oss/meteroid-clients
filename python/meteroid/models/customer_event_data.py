# this file is @generated
import dataclasses
import typing as t

from ..serialization import BaseModel
from .customer_id import CustomerId


@dataclasses.dataclass
class CustomerEventData(BaseModel):
    currency: str

    custom_properties: t.Dict[str, t.Any]
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    invoicing_emails: t.List[str]

    name: str

    alias: t.Optional[str] = None

    billing_email: t.Optional[str] = None

    phone: t.Optional[str] = None
