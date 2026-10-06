# this file is @generated
from __future__ import annotations

import dataclasses
import typing as t
from datetime import date, datetime

from ..serialization import BaseModel

if t.TYPE_CHECKING:
    from .coupon_line_item import CouponLineItem
    from .currency import Currency
    from .customer_details import CustomerDetails
    from .customer_id import CustomerId
    from .e_invoicing_status import EInvoicingStatus
    from .invoice_id import InvoiceId
    from .invoice_line_item import InvoiceLineItem
    from .invoice_payment_status import InvoicePaymentStatus
    from .invoice_status import InvoiceStatus
    from .invoice_type import InvoiceType
    from .subscription_id import SubscriptionId
    from .tax_breakdown_item import TaxBreakdownItem
    from .transaction import Transaction


@dataclasses.dataclass(kw_only=True)
class Invoice(BaseModel):
    """The `Invoice` object."""

    amount_due: int

    applied_credits: int

    coupons: list[CouponLineItem]

    created_at: datetime

    currency: Currency

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    customer_details: CustomerDetails

    customer_id: CustomerId

    id: InvoiceId

    invoice_date: date

    invoice_number: str

    invoice_type: InvoiceType

    line_items: list[InvoiceLineItem]

    net_terms: int

    payment_status: InvoicePaymentStatus

    status: InvoiceStatus

    subtotal: int

    subtotal_recurring: int

    tax_amount: int

    tax_breakdown: list[TaxBreakdownItem]

    total: int

    transactions: list[Transaction]

    billing_period_start: date | None = None
    """The period/moment this invoice is about — the subscription period start, or the invoice's
    own date for manual/one-off. Stable and always present, distinct from `invoice_date` (the
    emission date). Shown as "Invoice date"."""

    child_invoice_id: InvoiceId | None = None

    due_date: date | None = None

    einvoicing_status: EInvoicingStatus | None = None

    finalized_at: datetime | None = None

    marked_as_uncollectible_at: datetime | None = None

    memo: str | None = None

    paid_at: datetime | None = None

    parent_invoice_id: InvoiceId | None = None

    purchase_order: str | None = None

    reference: str | None = None

    subscription_id: SubscriptionId | None = None

    updated_at: datetime | None = None

    voided_at: datetime | None = None
