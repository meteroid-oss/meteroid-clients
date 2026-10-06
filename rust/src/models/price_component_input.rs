// this file is @generated
use serde::{Deserialize, Serialize};

use super::{fee::Fee, product_id::ProductId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct PriceComponentInput {
    pub fee: Fee,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product_id: Option<ProductId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PriceComponentInput {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(fee: Fee, name: impl Into<String>) -> Self {
        Self {
            fee,
            name: name.into(),
            product_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
