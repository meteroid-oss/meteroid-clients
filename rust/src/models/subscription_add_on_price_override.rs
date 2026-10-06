// this file is @generated
use serde::{Deserialize, Serialize};

use super::price_entry::PriceEntry;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionAddOnPriceOverride {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,

    pub price_entry: PriceEntry,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SubscriptionAddOnPriceOverride {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(price_entry: PriceEntry) -> Self {
        Self {
            name: None,
            price_entry,
            extra: serde_json::Map::new(),
        }
    }
}
