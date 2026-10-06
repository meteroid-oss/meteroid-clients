# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .customer_id import CustomerId
    from .invoice_id import InvoiceId
    from .invoice_status import InvoiceStatus


@dataclasses.dataclass(kw_only=True)
class InvoiceEventData(BaseModel):
    """The `InvoiceEventData` object."""

    created_at: datetime

    currency: str

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    invoice_id: InvoiceId

    status: InvoiceStatus

    tax_amount: int

    total: int

    consolidated_into_invoice_id: InvoiceId | None = None

    invoice_number: str | None = None
    """Absent while the invoice is a draft — the number is assigned at finalization."""

    parent_invoice_id: InvoiceId | None = None
