// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

pub struct Events<'a> {
    cfg: &'a Configuration,
}

impl<'a> Events<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    /// Ingest usage events for metering and billing purposes.
    pub async fn ingest_events(
        &self,
        ingest_events_request: crate::models::IngestEventsRequest,
    ) -> Result<crate::models::IngestEventsResponse> {
        crate::request::Request::new(http1::Method::POST, "/api/v1/events/ingest")
            .with_body_param(ingest_events_request)
            .execute(self.cfg)
            .await
    }
}
