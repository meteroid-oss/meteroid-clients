package main

import (
	"context"
	"net/url"
	"regexp"
	"strconv"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// listInvoices is `GET /api/invoices` — the workspace customer's invoices, newest first.
//
// A fresh workspace has no invoices, and one that just checked out usually has a DRAFT.
// Amounts stay integers in **minor units** — Meteroid models invoice money as an
// integer, not a decimal, and this is the one place the decimals-are-strings rule does
// not apply.
func (a *app) listInvoices(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	limit, err := limitParam(r.query)
	if err != nil {
		return nil, err
	}
	if limit < 1 || limit > 100 {
		return nil, badRequest("limit must be between 1 and 100.")
	}

	response, err := a.meteroid.Invoices().ListInvoices(ctx, &meteroid.InvoicesListInvoicesOptions{
		// CustomerId accepts an id or an alias.
		CustomerId: &session.customerAlias,
		OrderBy:    ptr("invoice_date.desc"),
		PerPage:    &limit,
	})
	if err != nil {
		return nil, upstream("GET /api/v1/invoices", err)
	}

	invoices := make([]Invoice, 0, len(response.Data))
	for _, invoice := range response.Data {
		invoices = append(invoices, Invoice{
			ID:            invoice.Id,
			InvoiceNumber: invoice.InvoiceNumber,
			Status:        string(invoice.Status),
			Currency:      string(invoice.Currency),
			InvoiceDate:   invoice.InvoiceDate,
			DueDate:       invoice.DueDate,
			Total:         invoice.Total,
			AmountDue:     invoice.AmountDue,
		})
	}
	return replyOK(InvoiceListResponse{Invoices: invoices})
}

var integer = regexp.MustCompile(`^[+-]?\d+$`)

// limitParam: the query string is as strict as the request bodies. `limit` is the only
// parameter the contract declares, it appears at most once, and it is an int32.
func limitParam(rawQuery string) (int32, error) {
	query, err := url.ParseQuery(rawQuery)
	if err != nil {
		return 0, badRequest("Invalid query string: %v.", err)
	}
	for name := range query {
		if name != "limit" {
			return 0, badRequest("Invalid query string: unknown parameter `%s`, expected `limit`.", name)
		}
	}

	values := query["limit"]
	if len(values) > 1 {
		return 0, badRequest("Invalid query string: `limit` was given more than once.")
	}
	if len(values) == 0 {
		return 20, nil
	}
	limit, err := strconv.ParseInt(values[0], 10, 32)
	if !integer.MatchString(values[0]) || err != nil {
		return 0, badRequest("Invalid query string: limit must be an integer.")
	}
	return int32(limit), nil
}
