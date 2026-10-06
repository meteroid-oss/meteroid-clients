// this file is @generated
use serde::{Deserialize, Serialize};

use super::{price_component_id::PriceComponentId, price_entry::PriceEntry};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ComponentOverride {
    pub component_id: PriceComponentId,

    pub name: String,

    pub price_entry: PriceEntry,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ComponentOverride {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        component_id: PriceComponentId,
        name: impl Into<String>,
        price_entry: PriceEntry,
    ) -> Self {
        Self {
            component_id,
            name: name.into(),
            price_entry,
            extra: serde_json::Map::new(),
        }
    }
}
