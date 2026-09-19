# this file is @generated
import enum


class EventType(str, enum.Enum):
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

    def __str__(self) -> str:
        return str(self.value)
