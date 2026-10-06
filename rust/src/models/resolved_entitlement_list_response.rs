// this file is @generated
use serde::{Deserialize, Serialize};

use super::resolved_entitlement::ResolvedEntitlement;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ResolvedEntitlementListResponse {
    pub data: Vec<ResolvedEntitlement>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ResolvedEntitlementListResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<ResolvedEntitlement>) -> Self {
        Self {
            data,
            extra: serde_json::Map::new(),
        }
    }
}
