// this file is @generated

export enum EventType {
  MetricCreated = "metric.created",
  CustomerCreated = "customer.created",
  SubscriptionCreated = "subscription.created",
  SubscriptionUpdated = "subscription.updated",
  SubscriptionCancelled = "subscription.cancelled",
  SubscriptionEnded = "subscription.ended",
  InvoiceCreated = "invoice.created",
  InvoiceFinalized = "invoice.finalized",
  InvoicePaid = "invoice.paid",
  InvoiceVoided = "invoice.voided",
  InvoiceClosed = "invoice.closed",
  InvoiceConsolidated = "invoice.consolidated",
  InvoiceDeleted = "invoice.deleted",
  QuoteAccepted = "quote.accepted",
  QuoteConverted = "quote.converted",
  CreditNoteCreated = "credit_note.created",
  CreditNoteFinalized = "credit_note.finalized",
  CreditNoteVoided = "credit_note.voided",
  PlanCreated = "plan.created",
  PlanPublished = "plan.published",
  PlanArchived = "plan.archived",
  ProductCreated = "product.created",
  ProductUpdated = "product.updated",
  ProductArchived = "product.archived",
  MetricUpdated = "metric.updated",
  MetricArchived = "metric.archived",
  CouponCreated = "coupon.created",
  CouponUpdated = "coupon.updated",
  CouponArchived = "coupon.archived",
  AddonCreated = "addon.created",
  AddonUpdated = "addon.updated",
  AddonArchived = "addon.archived",
}

export const EventTypeSerializer = {
  _fromJsonObject(object: any): EventType {
    return object;
  },

  _toJsonObject(self: EventType): any {
    return self;
  },
};
