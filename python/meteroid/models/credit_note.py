# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
from .credit_note_id import CreditNoteId
from .credit_note_status import CreditNoteStatus
from .credit_type import CreditType
from .currency import Currency
from .customer_id import CustomerId
from .invoice_id import InvoiceId
from .invoice_line_item import InvoiceLineItem
from .plan_version_id import PlanVersionId
from .subscription_id import SubscriptionId
from .tax_breakdown_item import TaxBreakdownItem


@dataclasses.dataclass
class CreditNote(BaseModel):
    created_at: datetime

    credit_note_number: str

    credit_type: CreditType

    credited_amount_cents: int

    currency: Currency

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    customer_id: CustomerId

    id: CreditNoteId

    invoice_id: InvoiceId

    invoice_number: str

    line_items: t.List[InvoiceLineItem]

    refunded_amount_cents: int

    status: CreditNoteStatus

    subtotal: int

    tax_amount: int

    tax_breakdown: t.List[TaxBreakdownItem]

    total: int

    finalized_at: t.Optional[datetime] = None

    memo: t.Optional[str] = None

    plan_version_id: t.Optional[PlanVersionId] = None

    reason: t.Optional[str] = None

    subscription_id: t.Optional[SubscriptionId] = None

    updated_at: t.Optional[datetime] = None

    voided_at: t.Optional[datetime] = None
