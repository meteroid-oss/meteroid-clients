// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CancelSubscriptionRequest {
    /// If not provided, the cancellation will be effective at the end of the current billing or committed period.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub effective_date: Option<chrono::NaiveDate>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub reason: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CancelSubscriptionRequest {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            effective_date: None,
            reason: None,
            extra: serde_json::Map::new(),
        }
    }
}
