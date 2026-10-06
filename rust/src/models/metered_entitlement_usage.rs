// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MeteredEntitlementUsage {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub consumed: Option<rust_decimal::Decimal>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub remaining: Option<rust_decimal::Decimal>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub reset_at: Option<chrono::DateTime<chrono::Utc>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MeteredEntitlementUsage {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            consumed: None,
            remaining: None,
            reset_at: None,
            extra: serde_json::Map::new(),
        }
    }
}
