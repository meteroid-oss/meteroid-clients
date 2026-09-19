# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .credit_note_id import CreditNoteId
from .credit_note_status import CreditNoteStatus
from .customer_id import CustomerId
from .invoice_id import InvoiceId
from .invoice_line_item import InvoiceLineItem
from .tax_breakdown_item import TaxBreakdownItem


@dataclasses.dataclass
class CreditNoteEventData(BaseModel):
    created_at: datetime

    credit_note_id: CreditNoteId

    credited_amount_cents: int

    currency: str

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition key."""

    customer_id: CustomerId

    invoice_id: InvoiceId

    line_items: t.List[InvoiceLineItem]
    """Credited line items (negated amounts)."""

    refunded_amount_cents: int

    status: CreditNoteStatus

    subtotal: int

    tax_amount: int

    tax_breakdown: t.List[TaxBreakdownItem]
    """Per-rate tax (VAT) breakdown for the credited amount."""

    total: int

    credit_note_number: t.Optional[str] = None
    """Absent while the credit note is a draft — the number is assigned at finalization."""

    invoice_number: t.Optional[str] = None
    """Number of the invoice being credited."""

    memo: t.Optional[str] = None

    reason: t.Optional[str] = None
