// this file is @generated
use serde::{Deserialize, Serialize};

use super::product_id::ProductId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExistingProductRef {
    pub id: ProductId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExistingProductRef {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(id: ProductId) -> Self {
        Self {
            id,
            extra: serde_json::Map::new(),
        }
    }
}
