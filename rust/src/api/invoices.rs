// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

#[derive(Default)]
pub struct InvoicesListInvoicesOptions {
    /// Filter by customer ID or alias
    pub customer_id: Option<String>,

    pub subscription_id: Option<SubscriptionId>,

    pub statuses: Option<Vec<InvoiceStatus>>,

    /// Page number (0-indexed)
    pub page: Option<i32>,

    /// Number of items per page
    pub per_page: Option<i32>,
}

pub struct Invoices<'a> {
    cfg: &'a Configuration,
}

impl<'a> Invoices<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    /// List invoices with optional filtering by customer, subscription, or status.
    pub async fn list_invoices(
        &self,
        options: Option<InvoicesListInvoicesOptions>,
    ) -> Result<crate::models::InvoiceListResponse> {
        let InvoicesListInvoicesOptions {
            customer_id,
            subscription_id,
            statuses,
            page,
            per_page,
        } = options.unwrap_or_default();

        crate::request::Request::new(http1::Method::GET, "/api/v1/invoices")
            .with_optional_query_param("customer_id", customer_id)
            .with_optional_query_param("subscription_id", subscription_id)
            .with_optional_query_param("statuses", statuses)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .execute(self.cfg)
            .await
    }

    /// Retrieve a single invoice with its payment transactions.
    pub async fn get_invoice_by_id(&self, invoice_id: String) -> Result<crate::models::Invoice> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/invoices/{invoice_id}")
            .with_path_param("invoice_id", invoice_id)
            .execute(self.cfg)
            .await
    }

    /// Download the PDF document for an invoice.
    pub async fn download_invoice_pdf(&self, invoice_id: String) -> Result<bytes::Bytes> {
        crate::request::Request::new(http1::Method::GET, "/api/v1/invoices/{invoice_id}/download")
            .with_path_param("invoice_id", invoice_id)
            .execute_binary(self.cfg)
            .await
    }
}
