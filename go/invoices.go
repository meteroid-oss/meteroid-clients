// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// InvoicesListInvoicesOptions carries the query and header parameters of
// Invoices.ListInvoices.
//
// Optional parameters are pointers; leave them nil to omit them.
type InvoicesListInvoicesOptions struct {
	// Filter by customer ID or alias
	CustomerId *string

	SubscriptionId *SubscriptionId

	Statuses []InvoiceStatus

	// Sort order. Format: `column.direction`. Allowed columns: `invoice_number`, `customer_name`, `amount`, `invoice_date`, `status`, `payment_status`. Direction: `asc` or `desc`. Default: `invoice_date.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// Invoices groups the invoices operations of the Meteroid API.
type Invoices struct {
	client *Client
}

// List invoices with optional filtering by customer, subscription, or status.
func (a *Invoices) ListInvoices(ctx context.Context, options *InvoicesListInvoicesOptions) (*InvoiceListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/invoices")

	if options != nil {
		if options.CustomerId != nil {
			req.SetQueryParam("customer_id", *options.CustomerId)
		}
		if options.SubscriptionId != nil {
			req.SetQueryParam("subscription_id", string(*options.SubscriptionId))
		}

		if len(options.Statuses) > 0 {
			for _, item := range options.Statuses {
				req.AddQueryParam("statuses", string(item))
			}
		}
		if options.OrderBy != nil {
			req.SetQueryParam("order_by", *options.OrderBy)
		}
		if options.Page != nil {
			req.SetQueryParam("page", formatInt(int64(*options.Page)))
		}
		if options.PerPage != nil {
			req.SetQueryParam("per_page", formatInt(int64(*options.PerPage)))
		}
	}

	var out InvoiceListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a single invoice with its payment transactions.
func (a *Invoices) GetInvoiceById(ctx context.Context, invoiceId string) (*Invoice, error) {
	req := newRequest(http.MethodGet, "/api/v1/invoices/{invoice_id}")
	req.SetPathParam("invoice_id", invoiceId)

	var out Invoice
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Merge custom property values onto an invoice (send a key with `null` to remove it).
// Values are validated against the tenant's `INVOICE` property definitions. Allowed at any
// status — custom properties are external workflow metadata and stay editable after the invoice
// is finalized.
func (a *Invoices) PatchInvoiceCustomProperties(ctx context.Context, invoiceId string, invoiceCustomPropertiesRequest InvoiceCustomPropertiesRequest) (*Invoice, error) {
	req := newRequest(http.MethodPatch, "/api/v1/invoices/{invoice_id}/custom-properties")
	req.SetPathParam("invoice_id", invoiceId)

	req.SetJSONBody(invoiceCustomPropertiesRequest)

	var out Invoice
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Download the PDF document for an invoice.
func (a *Invoices) DownloadInvoicePdf(ctx context.Context, invoiceId string) ([]byte, error) {
	req := newRequest(http.MethodGet, "/api/v1/invoices/{invoice_id}/download")
	req.SetPathParam("invoice_id", invoiceId)

	return a.client.executeBinary(ctx, req)
}
