// this file is @generated
use serde::{Deserialize, Serialize};

use super::{fee::Fee, price_component_id::PriceComponentId, product_id::ProductId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PriceComponent {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub fee: Option<Fee>,

    pub id: PriceComponentId,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product_id: Option<ProductId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PriceComponent {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(id: PriceComponentId, name: impl Into<String>) -> Self {
        Self {
            fee: None,
            id,
            name: name.into(),
            product_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
