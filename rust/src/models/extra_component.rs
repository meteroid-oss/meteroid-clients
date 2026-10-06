// this file is @generated
use serde::{Deserialize, Serialize};

use super::{price_entry::PriceEntry, product_ref::ProductRef};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExtraComponent {
    pub name: String,

    pub price_entry: PriceEntry,

    pub product_ref: ProductRef,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExtraComponent {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(name: impl Into<String>, price_entry: PriceEntry, product_ref: ProductRef) -> Self {
        Self {
            name: name.into(),
            price_entry,
            product_ref,
            extra: serde_json::Map::new(),
        }
    }
}
