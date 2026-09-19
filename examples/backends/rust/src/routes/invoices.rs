//! `GET /api/invoices` — the workspace customer's invoices, newest first.

use axum::{
    extract::{rejection::QueryRejection, Query, State},
    Json,
};
use meteroid_rs::api::InvoicesListInvoicesOptions;
use serde::Deserialize;

use crate::{
    dto::{Invoice, InvoiceListResponse},
    error::{upstream, ApiError, ApiResult},
    routes::query,
    session::Session,
    state::AppState,
};

#[derive(Debug, Deserialize)]
#[serde(deny_unknown_fields)]
pub struct InvoiceQuery {
    pub limit: Option<i32>,
}

/// A fresh workspace has no invoices, and one that just checked out usually has a
/// `DRAFT`. Amounts stay integers in **minor units** — Meteroid models invoice money as
/// an integer, not a decimal, and this is the one place the decimals-are-strings rule
/// does not apply.
pub async fn list_invoices(
    State(state): State<AppState>,
    session: Session,
    params: Result<Query<InvoiceQuery>, QueryRejection>,
) -> ApiResult<Json<InvoiceListResponse>> {
    let limit = query(params)?.limit.unwrap_or(20);
    if !(1..=100).contains(&limit) {
        return Err(ApiError::bad_request("limit must be between 1 and 100."));
    }

    let response = state
        .meteroid
        .invoices()
        .list_invoices(Some(InvoicesListInvoicesOptions {
            // `customer_id` accepts an id or an alias.
            customer_id: Some(session.customer_alias.clone()),
            order_by: Some("invoice_date.desc".to_string()),
            per_page: Some(limit),
            ..Default::default()
        }))
        .await
        .map_err(|err| upstream("GET /api/v1/invoices", err))?;

    Ok(Json(InvoiceListResponse {
        invoices: response
            .data
            .into_iter()
            .map(|invoice| Invoice {
                id: invoice.id,
                invoice_number: invoice.invoice_number,
                status: invoice.status.to_string(),
                currency: invoice.currency.to_string(),
                invoice_date: invoice.invoice_date,
                due_date: invoice.due_date,
                total: i64::from(invoice.total),
                amount_due: i64::from(invoice.amount_due),
            })
            .collect(),
    }))
}
