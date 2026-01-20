// this file is @generated
use serde::{Deserialize, Serialize};

use super::event::Event;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct IngestEventsRequest {
    /// allow ingesting events with timestamps more than a day in the past
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_backfilling: Option<bool>,

    pub events: Vec<Event>,
}

impl IngestEventsRequest {
    pub fn new(events: Vec<Event>) -> Self {
        Self {
            allow_backfilling: None,
            events,
        }
    }
}
