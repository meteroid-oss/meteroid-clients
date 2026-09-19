// this file is @generated
package meteroid

type SubscriptionUpdateRequest struct {
	// If false, invoices will stay in Draft until manually reviewed and finalized.
	AutoAdvanceInvoices *bool `json:"auto_advance_invoices,omitempty"`

	// Automatically try to charge the customer's configured payment method on finalize.
	ChargeAutomatically *bool `json:"charge_automatically,omitempty"`

	// Partial update of custom property values (merge; send a key with `null` to remove it).
	// Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged.
	CustomProperties map[string]any `json:"custom_properties,omitempty"`

	// Default memo for invoices
	InvoiceMemo *string `json:"invoice_memo,omitempty"`

	// Payment terms in days (0 = due on issue)
	NetTerms *int32 `json:"net_terms,omitempty"`

	PaymentMethodsConfig *PaymentMethodsConfig `json:"payment_methods_config,omitempty"`

	// Purchase order number
	PurchaseOrder *string `json:"purchase_order,omitempty"`
}
