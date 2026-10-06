# this file is @generated
import typing as t

from ..serialization import StrEnum


class EventType(StrEnum):
    """The values of `EventType`; others are kept as received."""

    METRIC_CREATED = "metric.created"
    CUSTOMER_CREATED = "customer.created"
    SUBSCRIPTION_CREATED = "subscription.created"
    SUBSCRIPTION_UPDATED = "subscription.updated"
    SUBSCRIPTION_CANCELLED = "subscription.cancelled"
    SUBSCRIPTION_ENDED = "subscription.ended"
    INVOICE_CREATED = "invoice.created"
    INVOICE_FINALIZED = "invoice.finalized"
    INVOICE_PAID = "invoice.paid"
    INVOICE_VOIDED = "invoice.voided"
    INVOICE_CLOSED = "invoice.closed"
    INVOICE_CONSOLIDATED = "invoice.consolidated"
    INVOICE_DELETED = "invoice.deleted"
    INVOICE_ACCOUNTING_PDF_GENERATED = "invoice.accounting_pdf_generated"
    QUOTE_ACCEPTED = "quote.accepted"
    QUOTE_CONVERTED = "quote.converted"
    CREDIT_NOTE_CREATED = "credit_note.created"
    CREDIT_NOTE_FINALIZED = "credit_note.finalized"
    CREDIT_NOTE_VOIDED = "credit_note.voided"
    PLAN_CREATED = "plan.created"
    PLAN_PUBLISHED = "plan.published"
    PLAN_ARCHIVED = "plan.archived"
    PRODUCT_CREATED = "product.created"
    PRODUCT_UPDATED = "product.updated"
    PRODUCT_ARCHIVED = "product.archived"
    METRIC_UPDATED = "metric.updated"
    METRIC_ARCHIVED = "metric.archived"
    COUPON_CREATED = "coupon.created"
    COUPON_UPDATED = "coupon.updated"
    COUPON_ARCHIVED = "coupon.archived"
    ADDON_CREATED = "addon.created"
    ADDON_UPDATED = "addon.updated"
    ADDON_ARCHIVED = "addon.archived"


EventTypeLiteral: t.TypeAlias = t.Literal[
    "metric.created",
    "customer.created",
    "subscription.created",
    "subscription.updated",
    "subscription.cancelled",
    "subscription.ended",
    "invoice.created",
    "invoice.finalized",
    "invoice.paid",
    "invoice.voided",
    "invoice.closed",
    "invoice.consolidated",
    "invoice.deleted",
    "invoice.accounting_pdf_generated",
    "quote.accepted",
    "quote.converted",
    "credit_note.created",
    "credit_note.finalized",
    "credit_note.voided",
    "plan.created",
    "plan.published",
    "plan.archived",
    "product.created",
    "product.updated",
    "product.archived",
    "metric.updated",
    "metric.archived",
    "coupon.created",
    "coupon.updated",
    "coupon.archived",
    "addon.created",
    "addon.updated",
    "addon.archived",
]
"""The values of :class:`EventType`, which arguments take as plain strings too."""
