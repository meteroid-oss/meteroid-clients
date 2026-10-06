// this file is @generated
use serde::{Deserialize, Serialize};

use super::address::Address;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ShippingAddress {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub address: Option<Address>,

    pub same_as_billing: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ShippingAddress {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(same_as_billing: bool) -> Self {
        Self {
            address: None,
            same_as_billing,
            extra: serde_json::Map::new(),
        }
    }
}
