// this file is @generated
#![allow(clippy::doc_markdown, clippy::default_trait_access)]
#[allow(unused_imports, clippy::wildcard_imports)]
use crate::{error::Result, models::*, Configuration};

/// The events API, from the client's
/// [`events`](crate::api::Meteroid::events).
#[derive(Clone)]
pub struct Events {
    cfg: std::sync::Arc<Configuration>,
    options: crate::api::RequestOptions,
}

impl std::fmt::Debug for Events {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        f.debug_struct("Events")
            .field("options", &self.options)
            .finish_non_exhaustive()
    }
}

impl Events {
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

    /// Ingest events
    ///
    /// Ingest usage events for metering and billing purposes.
    ///
    /// Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
    /// double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.
    ///
    /// By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body.
    ///
    /// `POST /api/v1/events/ingest`.
    ///
    /// # Errors
    ///
    /// An API error's body is [`RestErrorResponse`](crate::models::RestErrorResponse) (401, 429, 500).
    pub fn ingest(
        &self,
        ingest_events_request: crate::models::IngestEventsRequest,
    ) -> crate::api::Call<crate::models::IngestEventsResponse> {
        crate::request::Request::new(http::Method::POST, "/api/v1/events/ingest")
            .with_body_param(ingest_events_request)
            .with_options(&self.options)
            .json(&self.cfg)
    }
}
