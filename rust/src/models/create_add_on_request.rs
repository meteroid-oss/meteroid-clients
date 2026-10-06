// this file is @generated
use serde::{Deserialize, Serialize};

use super::{price_id::PriceId, product_id::ProductId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateAddOnRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_instances_per_subscription: Option<i32>,

    pub name: String,

    pub price_id: PriceId,

    pub product_id: ProductId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub self_serviceable: Option<bool>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateAddOnRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(name: impl Into<String>, price_id: PriceId, product_id: ProductId) -> Self {
        Self {
            description: None,
            max_instances_per_subscription: None,
            name: name.into(),
            price_id,
            product_id,
            self_serviceable: None,
            extra: serde_json::Map::new(),
        }
    }
}
