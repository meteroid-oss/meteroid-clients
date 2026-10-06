// this file is @generated
use serde::{Deserialize, Serialize};

use super::price_id::PriceId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExistingPriceRef {
    pub id: PriceId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExistingPriceRef {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(id: PriceId) -> Self {
        Self {
            id,
            extra: serde_json::Map::new(),
        }
    }
}
