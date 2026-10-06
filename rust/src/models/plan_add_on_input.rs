// this file is @generated
use serde::{Deserialize, Serialize};

use super::{add_on_id::AddOnId, price_id::PriceId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct PlanAddOnInput {
    pub add_on_id: AddOnId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_instances: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub price_id: Option<PriceId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub self_serviceable: Option<bool>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PlanAddOnInput {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(add_on_id: AddOnId) -> Self {
        Self {
            add_on_id,
            max_instances: None,
            price_id: None,
            self_serviceable: None,
            extra: serde_json::Map::new(),
        }
    }
}
