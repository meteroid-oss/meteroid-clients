# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
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


@dataclasses.dataclass(kw_only=True)
class CreditNote(BaseModel):
    """The `CreditNote` object."""

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

    line_items: list[InvoiceLineItem]

    refunded_amount_cents: int

    status: CreditNoteStatus

    subtotal: int

    tax_amount: int

    tax_breakdown: list[TaxBreakdownItem]

    total: int

    finalized_at: datetime | None = None

    memo: str | None = None

    plan_version_id: PlanVersionId | None = None

    reason: str | None = None

    subscription_id: SubscriptionId | None = None

    updated_at: datetime | None = None

    voided_at: datetime | None = None
