package com.scribe.routes;

import com.meteroid.api.InvoicesListInvoicesOptions;
import com.meteroid.models.Invoice;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.Routes;
import com.scribe.SessionToken;
import com.scribe.Upstream;

import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

/** {@code GET /api/invoices} — the workspace customer's invoices, newest first. */
public final class InvoiceRoutes {

    private InvoiceRoutes() {}

    /**
     * A fresh workspace has no invoices, and one that just checked out usually has a {@code DRAFT}.
     * Amounts stay integers in <b>minor units</b> — Meteroid models invoice money as an integer, not
     * a decimal, and this is the one place the decimals-are-strings rule does not apply.
     */
    public static void listInvoices(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);
        int limit = Routes.intQueryParam(ctx, "limit", 20, 1, 100);

        InvoicesListInvoicesOptions options = new InvoicesListInvoicesOptions();
        // `customer_id` accepts an id or an alias.
        options.setCustomerId(alias);
        options.setOrderBy("invoice_date.desc");
        options.setPerPage(limit);

        List<Invoice> invoices =
                Upstream.call(
                                "GET /api/v1/invoices",
                                () -> state.meteroid.getInvoices().listInvoices(options))
                        .getData();

        List<Dto.Invoice> projected = new ArrayList<>(invoices.size());
        for (Invoice invoice : invoices) {
            projected.add(
                    new Dto.Invoice(
                            invoice.getId(),
                            invoice.getInvoiceNumber(),
                            invoice.getStatus().getValue(),
                            invoice.getCurrency().getValue(),
                            invoice.getInvoiceDate(),
                            invoice.getDueDate(),
                            invoice.getTotal(),
                            invoice.getAmountDue()));
        }

        ctx.json(new Dto.InvoiceListResponse(projected));
    }
}
