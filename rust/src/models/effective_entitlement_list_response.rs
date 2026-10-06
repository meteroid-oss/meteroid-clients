// this file is @generated
use serde::{Deserialize, Serialize};

use super::effective_entitlement::EffectiveEntitlement;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct EffectiveEntitlementListResponse {
    pub data: Vec<EffectiveEntitlement>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl EffectiveEntitlementListResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<EffectiveEntitlement>) -> Self {
        Self {
            data,
            extra: serde_json::Map::new(),
        }
    }
}
