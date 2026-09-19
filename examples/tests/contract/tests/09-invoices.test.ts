/**
 * `GET /api/invoices`.
 *
 * The money assertion is the one worth having. Invoice amounts are the single place in
 * this contract where a value is an **integer in minor units** rather than a decimal
 * string — Meteroid models invoice money as an integer — and it is exactly the kind of
 * inconsistency somebody eventually "fixes" into a string for uniformity, silently
 * dividing every total by a hundred somewhere downstream.
 */

import { describe, expect, it } from 'vitest';

import { api } from '../src/api.js';
import { expectError, expectStatus } from '../src/assert.js';
import { sharedSession, SUBSCRIBED_WORKSPACE_HINT, subscribedToken } from '../src/session.js';
import { skipTest } from '../src/skip.js';
import type { Invoice, InvoiceListResponse } from '../src/types.js';

function assertInvoices(invoices: Invoice[]): void {
  const dates = invoices.map((invoice) => invoice.invoice_date);
  const sorted = [...dates].sort().reverse();
  expect(dates, 'invoices are newest first').toEqual(sorted);

  for (const invoice of invoices) {
    expect(
      Number.isInteger(invoice.total),
      `invoice ${invoice.invoice_number}: total must be an integer count of minor units, got ` +
        `${JSON.stringify(invoice.total)}`,
    ).toBe(true);
    expect(Number.isInteger(invoice.amount_due)).toBe(true);
    expect(invoice.invoice_number.length).toBeGreaterThan(0);
  }
}

describe('GET /api/invoices', () => {
  it('rejects an unauthenticated request', async () => {
    expectError(await api.listInvoices(undefined), 401, 'UNAUTHORIZED');
  });

  it('returns an empty list for a workspace that has never been billed', async () => {
    const session = await sharedSession();
    const invoices = expectStatus<InvoiceListResponse>(
      await api.listInvoices(session.token),
      200,
    ).invoices;

    // A fresh workspace has no subscription, so Meteroid has issued it nothing. An empty
    // array — not a 404, not a null.
    expect(invoices).toEqual([]);
  });

  it('honours the limit parameter', async () => {
    const session = await sharedSession();
    const invoices = expectStatus<InvoiceListResponse>(
      await api.listInvoices(session.token, { limit: 1 }),
      200,
    ).invoices;
    expect(invoices.length).toBeLessThanOrEqual(1);
  });

  it('rejects a limit outside the documented range', async () => {
    const session = await sharedSession();
    expectError(await api.listInvoices(session.token, { limit: 0 }), 400, 'BAD_REQUEST');
    expectError(await api.listInvoices(session.token, { limit: 101 }), 400, 'BAD_REQUEST');
  });

  it('rejects a non-numeric limit', async () => {
    const session = await sharedSession();
    expectError(await api.listInvoices(session.token, { limit: 'all' }), 400, 'BAD_REQUEST');
  });

  it('reports money as integer minor units, newest first', async (context) => {
    const token = subscribedToken();
    if (!token) {
      skipTest(
        context,
        `only a workspace that has been billed has invoices to check. ${SUBSCRIBED_WORKSPACE_HINT}`,
      );
    }

    const invoices = expectStatus<InvoiceListResponse>(
      await api.listInvoices(token),
      200,
    ).invoices;

    if (invoices.length === 0) {
      skipTest(
        context,
        'the configured subscribed workspace has no invoices yet — Meteroid usually drafts one ' +
          'shortly after checkout, so try again in a minute.',
      );
    }
    assertInvoices(invoices);
    console.info(
      `  → ${invoices.length} invoice(s), newest ${invoices[0].invoice_number} ` +
        `(${invoices[0].status}, total ${invoices[0].total} minor units ${invoices[0].currency})`,
    );
  });
});
