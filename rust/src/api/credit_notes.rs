// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// Query and header parameters of [`CreditNotes::list`].
#[derive(Clone, Debug, Default)]
#[non_exhaustive]
pub struct CreditNotesListOptions {
    /// Filter by customer ID
    pub customer_id: Option<CustomerId>,
    /// Filter by invoice ID
    pub invoice_id: Option<InvoiceId>,
    /// The `status` query parameter.
    pub status: Option<CreditNoteStatus>,
    /// Free-text search over credit note number.
    pub search: Option<String>,
    /// Sort order. Format: `column.direction`. Allowed columns: `created_at`, `credit_note_number`, `total`, `status`. Direction: `asc` or `desc`. Default: `created_at.desc`.
    pub order_by: Option<String>,
    /// Page number (0-indexed)
    pub page: Option<i32>,
    /// Number of items per page
    pub per_page: Option<i32>,
}

impl CreditNotesListOptions {
    /// Options with no parameter set.
    #[must_use]
    pub fn new() -> Self {
        Self {
            customer_id: None,
            invoice_id: None,
            status: None,
            search: None,
            order_by: None,
            page: None,
            per_page: None,
        }
    }

    /// Sets the `customer_id` query parameter.
    #[must_use]
    pub fn customer_id(mut self, customer_id: impl Into<CustomerId>) -> Self {
        self.customer_id = Some(customer_id.into());
        self
    }

    /// Sets the `invoice_id` query parameter.
    #[must_use]
    pub fn invoice_id(mut self, invoice_id: impl Into<InvoiceId>) -> Self {
        self.invoice_id = Some(invoice_id.into());
        self
    }

    /// Sets the `status` query parameter.
    #[must_use]
    pub fn status(mut self, status: impl Into<CreditNoteStatus>) -> Self {
        self.status = Some(status.into());
        self
    }

    /// Sets the `search` query parameter.
    #[must_use]
    pub fn search(mut self, search: impl Into<String>) -> Self {
        self.search = Some(search.into());
        self
    }

    /// Sets the `order_by` query parameter.
    #[must_use]
    pub fn order_by(mut self, order_by: impl Into<String>) -> Self {
        self.order_by = Some(order_by.into());
        self
    }

    /// Sets the `page` query parameter.
    #[must_use]
    pub fn page(mut self, page: impl Into<i32>) -> Self {
        self.page = Some(page.into());
        self
    }

    /// Sets the `per_page` query parameter.
    #[must_use]
    pub fn per_page(mut self, per_page: impl Into<i32>) -> Self {
        self.per_page = Some(per_page.into());
        self
    }
}

/// The credit notes API, from the client's
/// [`credit_notes`](crate::api::Meteroid::credit_notes).
#[derive(Clone)]
pub struct CreditNotes {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for CreditNotes {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("CreditNotes")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl CreditNotes {
    pub(super) fn new(cfg: std::sync::Arc<Configuration>) -> Self {
        Self {
            cfg,
            options: crate::api::RequestOptions::default(),
        }
    }

    /// Applies `options` (headers, timeout, retries, idempotency key) to the calls made
    /// through the returned value.
    #[must_use]
    pub fn with_options(mut self, options: crate::api::RequestOptions) -> Self {
        self.options = options;
        self
    }

    /// List credit notes
    ///
    /// List a tenant's credit notes, optionally filtered by customer, invoice or status.
    ///
    /// `GET /api/v1/credit-notes`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn list(
        &self,
        options: impl Into<Option<CreditNotesListOptions>>,
    ) -> crate::api::Call<crate::models::CreditNoteListResponse> {
        let CreditNotesListOptions {
            customer_id,
            invoice_id,
            status,
            search,
            order_by,
            page,
            per_page,
        } = options.into().unwrap_or_default();

        crate::request::Request::new(http::Method::GET, "/api/v1/credit-notes")
            .with_optional_query_param("customer_id", customer_id)
            .with_optional_query_param("invoice_id", invoice_id)
            .with_optional_query_param("status", status)
            .with_optional_query_param("search", search)
            .with_optional_query_param("order_by", order_by)
            .with_optional_query_param("page", page)
            .with_optional_query_param("per_page", per_page)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Get credit note
    ///
    /// Retrieve a single credit note by ID.
    ///
    /// `GET /api/v1/credit-notes/{credit_note_id}`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn retrieve(&self, credit_note_id: &str) -> crate::api::Call<crate::models::CreditNote> {
        crate::request::Request::new(http::Method::GET, "/api/v1/credit-notes/{credit_note_id}")
            .with_path_param("credit_note_id", credit_note_id)
            .with_options(&self.options)
            .json(&self.cfg)
    }

    /// Update credit note custom properties
    ///
    /// Merge custom property values onto a credit note (send a key with `null` to remove it).
    /// Values are validated against the tenant's `CREDIT_NOTE` property definitions. Allowed at any
    /// status — custom properties are external workflow metadata and stay editable after the credit
    /// note is finalized.
    ///
    /// `PATCH /api/v1/credit-notes/{credit_note_id}/custom-properties`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (400, 401, 404, 429, 500).
    pub fn update_custom_properties(
        &self,
        credit_note_id: &str,
        credit_note_custom_properties_request: crate::models::CreditNoteCustomPropertiesRequest,
    ) -> crate::api::Call<crate::models::CreditNote> {
        crate::request::Request::new(
            http::Method::PATCH,
            "/api/v1/credit-notes/{credit_note_id}/custom-properties",
        )
        .with_path_param("credit_note_id", credit_note_id)
        .with_body_param(credit_note_custom_properties_request)
        .with_options(&self.options)
        .json(&self.cfg)
    }

    /// `GET /api/v1/credit-notes/{credit_note_id}/download`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn download(&self, credit_note_id: &str) -> crate::api::Call<bytes::Bytes> {
        crate::request::Request::new(
            http::Method::GET,
            "/api/v1/credit-notes/{credit_note_id}/download",
        )
        .with_path_param("credit_note_id", credit_note_id)
        .with_options(&self.options)
        .binary(&self.cfg)
    }

    /// Download credit note e-invoice XML
    ///
    /// Download the structured e-invoice (EN 16931 XML) issued with a credit note. For
    /// Factur-X the same XML is also embedded in the PDF.
    ///
    /// `GET /api/v1/credit-notes/{credit_note_id}/xml`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 404, 429, 500).
    pub fn download_xml(&self, credit_note_id: &str) -> crate::api::Call<bytes::Bytes> {
        crate::request::Request::new(
            http::Method::GET,
            "/api/v1/credit-notes/{credit_note_id}/xml",
        )
        .with_path_param("credit_note_id", credit_note_id)
        .with_options(&self.options)
        .binary(&self.cfg)
    }
}
