# this file is @generated
import dataclasses
import typing as t
from datetime import datetime

from ..serialization import BaseModel
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


@dataclasses.dataclass
class Invoice(BaseModel):
    amount_due: int

    applied_credits: int

    coupons: t.List[CouponLineItem]

    created_at: datetime

    currency: Currency

    custom_properties: t.Any
    """User-defined custom property values, keyed by definition `key`."""

    customer_details: CustomerDetails

    customer_id: CustomerId

    id: InvoiceId

    invoice_date: str

    invoice_number: str

    invoice_type: InvoiceType

    line_items: t.List[InvoiceLineItem]

    net_terms: int

    payment_status: InvoicePaymentStatus

    status: InvoiceStatus

    subtotal: int

    subtotal_recurring: int

    tax_amount: int

    tax_breakdown: t.List[TaxBreakdownItem]

    total: int

    transactions: t.List[Transaction]

    billing_period_start: t.Optional[str] = None
    """The period/moment this invoice is about — the subscription period start, or the invoice's
    own date for manual/one-off. Stable and always present, distinct from `invoice_date` (the
    emission date). Shown as "Invoice date"."""

    child_invoice_id: t.Optional[InvoiceId] = None

    due_date: t.Optional[str] = None

    einvoicing_status: t.Optional[EInvoicingStatus] = None

    finalized_at: t.Optional[datetime] = None

    marked_as_uncollectible_at: t.Optional[datetime] = None

    memo: t.Optional[str] = None

    paid_at: t.Optional[datetime] = None

    parent_invoice_id: t.Optional[InvoiceId] = None

    purchase_order: t.Optional[str] = None

    reference: t.Optional[str] = None

    subscription_id: t.Optional[SubscriptionId] = None

    updated_at: t.Optional[datetime] = None

    voided_at: t.Optional[datetime] = None
