// this file is @generated
use serde::{Deserialize, Serialize};

use super::product_id::ProductId;

/// Minimal reference to the product a feature belongs to.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct EntitlementProductRef {
    pub id: ProductId,

    pub name: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl EntitlementProductRef {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(id: ProductId, name: impl Into<String>) -> Self {
        Self {
            id,
            name: name.into(),
            extra: serde_json::Map::new(),
        }
    }
}
