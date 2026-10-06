// this file is @generated

export const EventType = {
  MetricCreated: "metric.created",
  CustomerCreated: "customer.created",
  SubscriptionCreated: "subscription.created",
  SubscriptionUpdated: "subscription.updated",
  SubscriptionCancelled: "subscription.cancelled",
  SubscriptionEnded: "subscription.ended",
  InvoiceCreated: "invoice.created",
  InvoiceFinalized: "invoice.finalized",
  InvoicePaid: "invoice.paid",
  InvoiceVoided: "invoice.voided",
  InvoiceClosed: "invoice.closed",
  InvoiceConsolidated: "invoice.consolidated",
  InvoiceDeleted: "invoice.deleted",
  InvoiceAccountingPdfGenerated: "invoice.accounting_pdf_generated",
  QuoteAccepted: "quote.accepted",
  QuoteConverted: "quote.converted",
  CreditNoteCreated: "credit_note.created",
  CreditNoteFinalized: "credit_note.finalized",
  CreditNoteVoided: "credit_note.voided",
  PlanCreated: "plan.created",
  PlanPublished: "plan.published",
  PlanArchived: "plan.archived",
  ProductCreated: "product.created",
  ProductUpdated: "product.updated",
  ProductArchived: "product.archived",
  MetricUpdated: "metric.updated",
  MetricArchived: "metric.archived",
  CouponCreated: "coupon.created",
  CouponUpdated: "coupon.updated",
  CouponArchived: "coupon.archived",
  AddonCreated: "addon.created",
  AddonUpdated: "addon.updated",
  AddonArchived: "addon.archived",
} as const;
export type EventType = (typeof EventType)[keyof typeof EventType] | (string & {});

/** Converts `EventType` values from (`parse`) and to (`serialize`) their JSON form. */
export const EventTypeSerializer = {
  parse(json: any): EventType {
    return json;
  },

  serialize(value: EventType): any {
    return value;
  },
};
