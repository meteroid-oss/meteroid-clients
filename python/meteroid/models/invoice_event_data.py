# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .customer_id import CustomerId
from .invoice_id import InvoiceId
from .invoice_status import InvoiceStatus


@dataclasses.dataclass
class InvoiceEventData(BaseModel):
    created_at: datetime

    currency: str

    custom_properties: t.Dict[str, t.Any]
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    invoice_id: InvoiceId

    status: InvoiceStatus

    tax_amount: int

    total: int

    consolidated_into_invoice_id: t.Optional[InvoiceId] = None

    invoice_number: t.Optional[str] = None
    """Absent while the invoice is a draft — the number is assigned at finalization."""

    parent_invoice_id: t.Optional[InvoiceId] = None
