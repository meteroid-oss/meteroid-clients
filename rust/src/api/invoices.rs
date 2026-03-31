// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

pub struct Invoices<'a> {
    cfg: &'a Configuration,
}

impl<'a> Invoices<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
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
