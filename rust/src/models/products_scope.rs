// this file is @generated
use serde::{Deserialize, Serialize};

/// Only lines for the listed products count. A product is the identity shared by plan
/// components, overrides and ad-hoc extras, so a subscription's billed set is matched uniformly.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ProductsScope {
    pub product_ids: Vec<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ProductsScope {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(product_ids: Vec<String>) -> Self {
        Self {
            product_ids,
            extra: serde_json::Map::new(),
        }
    }
}
