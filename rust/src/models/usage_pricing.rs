// this file is @generated
use serde::{Deserialize, Serialize};

use super::usage_pricing_model::UsagePricingModel;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct UsagePricing {
    pub model: UsagePricingModel,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UsagePricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(model: UsagePricingModel) -> Self {
        Self {
            model,
            extra: serde_json::Map::new(),
        }
    }
}
