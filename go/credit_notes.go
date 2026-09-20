// this file is @generated
package meteroid

import (
	"context"
	"net/http"
)

// CreditNotesListCreditNotesOptions carries the query and header parameters of
// CreditNotes.ListCreditNotes.
//
// Optional parameters are pointers; leave them nil to omit them.
type CreditNotesListCreditNotesOptions struct {
	// Filter by customer ID
	CustomerId *CustomerId

	// Filter by invoice ID
	InvoiceId *InvoiceId

	Status *CreditNoteStatus

	// Free-text search over credit note number.
	Search *string

	// Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
	OrderBy *string

	// Page number (0-indexed)
	Page *int32

	// Number of items per page
	PerPage *int32
}

// CreditNotes groups the credit notes operations of the Meteroid API.
type CreditNotes struct {
	client *Client
}

// List a tenant's credit notes, optionally filtered by customer, invoice or status.
func (a *CreditNotes) ListCreditNotes(ctx context.Context, options *CreditNotesListCreditNotesOptions) (*CreditNoteListResponse, error) {
	req := newRequest(http.MethodGet, "/api/v1/credit-notes")

	if options != nil {
		if options.CustomerId != nil {
			req.SetQueryParam("customer_id", string(*options.CustomerId))
		}
		if options.InvoiceId != nil {
			req.SetQueryParam("invoice_id", string(*options.InvoiceId))
		}
		if options.Status != nil {
			req.SetQueryParam("status", string(*options.Status))
		}
		if options.Search != nil {
			req.SetQueryParam("search", *options.Search)
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

	var out CreditNoteListResponse
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Retrieve a single credit note by ID.
func (a *CreditNotes) GetCreditNoteById(ctx context.Context, creditNoteId string) (*CreditNote, error) {
	req := newRequest(http.MethodGet, "/api/v1/credit-notes/{credit_note_id}")
	req.SetPathParam("credit_note_id", creditNoteId)

	var out CreditNote
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

// Merge custom property values onto a credit note (send a key with `null` to remove it).
// Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
// status — custom properties are external workflow metadata and stay editable after the credit
// note is finalized.
func (a *CreditNotes) PatchCreditNoteCustomProperties(ctx context.Context, creditNoteId string, creditNoteCustomPropertiesRequest CreditNoteCustomPropertiesRequest) (*CreditNote, error) {
	req := newRequest(http.MethodPatch, "/api/v1/credit-notes/{credit_note_id}/custom-properties")
	req.SetPathParam("credit_note_id", creditNoteId)

	req.SetJSONBody(creditNoteCustomPropertiesRequest)

	var out CreditNote
	if err := a.client.execute(ctx, req, &out); err != nil {
		return nil, err
	}
	return &out, nil
}

func (a *CreditNotes) DownloadCreditNotePdf(ctx context.Context, creditNoteId string) ([]byte, error) {
	req := newRequest(http.MethodGet, "/api/v1/credit-notes/{credit_note_id}/download")
	req.SetPathParam("credit_note_id", creditNoteId)

	return a.client.executeBinary(ctx, req)
}

// Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
// Factur-X the same XML is also embedded in the PDF.
func (a *CreditNotes) DownloadCreditNoteXml(ctx context.Context, creditNoteId string) ([]byte, error) {
	req := newRequest(http.MethodGet, "/api/v1/credit-notes/{credit_note_id}/xml")
	req.SetPathParam("credit_note_id", creditNoteId)

	return a.client.executeBinary(ctx, req)
}
