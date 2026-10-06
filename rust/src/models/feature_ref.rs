// this file is @generated
use serde::{Deserialize, Serialize};

use super::{entitlement_product_ref::EntitlementProductRef, feature_id::FeatureId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct FeatureRef {
    /// Unique key used to reference this feature in your code. Cannot be changed after creation.
    pub code: String,

    pub id: FeatureId,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product: Option<EntitlementProductRef>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl FeatureRef {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(code: impl Into<String>, id: FeatureId, name: impl Into<String>) -> Self {
        Self {
            code: code.into(),
            id,
            name: name.into(),
            product: None,
            extra: serde_json::Map::new(),
        }
    }
}
