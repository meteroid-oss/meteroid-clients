// this file is @generated
use serde::{Deserialize, Serialize};

use super::term_rate::TermRate;

/// Recurring rate fee (e.g., monthly subscription)
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct RatePlanFee {
    pub rates: Vec<TermRate>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl RatePlanFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(rates: Vec<TermRate>) -> Self {
        Self {
            rates,
            extra: serde_json::Map::new(),
        }
    }
}
