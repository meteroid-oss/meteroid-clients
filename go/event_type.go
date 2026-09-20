// this file is @generated
package meteroid

type EventType string

// Known values of EventType.
//
// The API may add new values over time; unknown values round-trip unchanged.
const (
	EventTypeMetricCreated                 EventType = "metric.created"
	EventTypeCustomerCreated               EventType = "customer.created"
	EventTypeSubscriptionCreated           EventType = "subscription.created"
	EventTypeSubscriptionUpdated           EventType = "subscription.updated"
	EventTypeSubscriptionCancelled         EventType = "subscription.cancelled"
	EventTypeSubscriptionEnded             EventType = "subscription.ended"
	EventTypeInvoiceCreated                EventType = "invoice.created"
	EventTypeInvoiceFinalized              EventType = "invoice.finalized"
	EventTypeInvoicePaid                   EventType = "invoice.paid"
	EventTypeInvoiceVoided                 EventType = "invoice.voided"
	EventTypeInvoiceClosed                 EventType = "invoice.closed"
	EventTypeInvoiceConsolidated           EventType = "invoice.consolidated"
	EventTypeInvoiceDeleted                EventType = "invoice.deleted"
	EventTypeInvoiceAccountingPdfGenerated EventType = "invoice.accounting_pdf_generated"
	EventTypeQuoteAccepted                 EventType = "quote.accepted"
	EventTypeQuoteConverted                EventType = "quote.converted"
	EventTypeCreditNoteCreated             EventType = "credit_note.created"
	EventTypeCreditNoteFinalized           EventType = "credit_note.finalized"
	EventTypeCreditNoteVoided              EventType = "credit_note.voided"
	EventTypePlanCreated                   EventType = "plan.created"
	EventTypePlanPublished                 EventType = "plan.published"
	EventTypePlanArchived                  EventType = "plan.archived"
	EventTypeProductCreated                EventType = "product.created"
	EventTypeProductUpdated                EventType = "product.updated"
	EventTypeProductArchived               EventType = "product.archived"
	EventTypeMetricUpdated                 EventType = "metric.updated"
	EventTypeMetricArchived                EventType = "metric.archived"
	EventTypeCouponCreated                 EventType = "coupon.created"
	EventTypeCouponUpdated                 EventType = "coupon.updated"
	EventTypeCouponArchived                EventType = "coupon.archived"
	EventTypeAddonCreated                  EventType = "addon.created"
	EventTypeAddonUpdated                  EventType = "addon.updated"
	EventTypeAddonArchived                 EventType = "addon.archived"
)

// AllEventTypeValues lists every EventType value known to this SDK version.
var AllEventTypeValues = []EventType{
	EventTypeMetricCreated,
	EventTypeCustomerCreated,
	EventTypeSubscriptionCreated,
	EventTypeSubscriptionUpdated,
	EventTypeSubscriptionCancelled,
	EventTypeSubscriptionEnded,
	EventTypeInvoiceCreated,
	EventTypeInvoiceFinalized,
	EventTypeInvoicePaid,
	EventTypeInvoiceVoided,
	EventTypeInvoiceClosed,
	EventTypeInvoiceConsolidated,
	EventTypeInvoiceDeleted,
	EventTypeInvoiceAccountingPdfGenerated,
	EventTypeQuoteAccepted,
	EventTypeQuoteConverted,
	EventTypeCreditNoteCreated,
	EventTypeCreditNoteFinalized,
	EventTypeCreditNoteVoided,
	EventTypePlanCreated,
	EventTypePlanPublished,
	EventTypePlanArchived,
	EventTypeProductCreated,
	EventTypeProductUpdated,
	EventTypeProductArchived,
	EventTypeMetricUpdated,
	EventTypeMetricArchived,
	EventTypeCouponCreated,
	EventTypeCouponUpdated,
	EventTypeCouponArchived,
	EventTypeAddonCreated,
	EventTypeAddonUpdated,
	EventTypeAddonArchived,
}

// String returns the wire representation of the value.
func (e EventType) String() string {
	return string(e)
}

// IsKnown reports whether the value is one this SDK version knows about.
func (e EventType) IsKnown() bool {
	for _, known := range AllEventTypeValues {
		if e == known {
			return true
		}
	}
	return false
}
