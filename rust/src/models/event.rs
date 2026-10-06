// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct Event {
    /// Billable metric code. Max 512 characters.
    pub code: String,

    /// Meteroid customer ID or external customer alias.
    pub customer_id: String,

    /// Unique event identifier. Max 255 characters. A UUID or ULID is recommended.
    pub event_id: String,

    /// Arbitrary string key-value pairs used by billable metrics for filtering and aggregation.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub properties: Option<std::collections::HashMap<String, String>>,

    /// RFC 3339 timestamp. Defaults to ingestion time if omitted.
    /// Must be between 24 hours ago and 1 hour from now. Set `allow_backfilling` to remove the past limit.
    pub timestamp: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Event {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        code: impl Into<String>,
        customer_id: impl Into<String>,
        event_id: impl Into<String>,
        timestamp: impl Into<String>,
    ) -> Self {
        Self {
            code: code.into(),
            customer_id: customer_id.into(),
            event_id: event_id.into(),
            properties: None,
            timestamp: timestamp.into(),
            extra: serde_json::Map::new(),
        }
    }
}
