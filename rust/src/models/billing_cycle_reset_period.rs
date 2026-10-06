// this file is @generated
use serde::{Deserialize, Serialize};

/// Resets each time your subscription renews — anchored to your billing cycle.
#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct BillingCycleResetPeriod {
    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl BillingCycleResetPeriod {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            extra: serde_json::Map::new(),
        }
    }
}
