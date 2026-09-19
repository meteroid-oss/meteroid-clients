/** `GET /api/invoices` — the workspace customer's invoices, newest first. */

import type { InvoiceListResponse } from "../dto.js";
import { ApiError, upstream } from "../error.js";
import { ok, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";

/**
 * A fresh workspace has no invoices, and one that just checked out usually has a
 * `DRAFT`. Amounts stay integers in **minor units** — Meteroid models invoice money as
 * an integer, not a decimal, and this is the one place the decimals-are-strings rule
 * does not apply.
 */
export async function listInvoices(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<InvoiceListResponse>> {
  const session = requireSession(state, request);
  const limit = limitParam(request.query) ?? 20;
  if (limit < 1 || limit > 100) {
    throw ApiError.badRequest("limit must be between 1 and 100.");
  }

  const response = await state.meteroid.invoices
    .listInvoices({
      // `customerId` accepts an id or an alias.
      customerId: session.customerAlias,
      orderBy: "invoice_date.desc",
      perPage: limit,
    })
    .catch(upstream("GET /api/v1/invoices"));

  return ok({
    invoices: response.data.map((invoice) => ({
      id: invoice.id,
      invoice_number: invoice.invoiceNumber,
      status: invoice.status,
      currency: invoice.currency,
      invoice_date: invoice.invoiceDate,
      due_date: invoice.dueDate ?? null,
      total: invoice.total,
      amount_due: invoice.amountDue,
    })),
  });
}

/**
 * The query string is as strict as the request bodies: `limit` is the only parameter
 * the contract declares, it appears at most once, and it is an int32.
 */
function limitParam(query: URLSearchParams): number | null {
  for (const name of query.keys()) {
    if (name !== "limit") {
      throw ApiError.badRequest(`Invalid query string: unknown parameter \`${name}\`, expected \`limit\`.`);
    }
  }
  const values = query.getAll("limit");
  if (values.length > 1) {
    throw ApiError.badRequest("Invalid query string: `limit` was given more than once.");
  }

  const raw = values[0];
  if (raw === undefined) {
    return null;
  }
  const limit = /^[+-]?\d+$/.test(raw) ? Number(raw) : Number.NaN;
  if (!Number.isInteger(limit) || Math.abs(limit) > 2_147_483_647) {
    throw ApiError.badRequest("Invalid query string: limit must be an integer.");
  }
  return limit;
}
