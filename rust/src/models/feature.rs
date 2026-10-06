// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    entitlement::Entitlement, entitlement_product_ref::EntitlementProductRef,
    feature_id::FeatureId, feature_status::FeatureStatus, feature_type::FeatureType,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Feature {
    /// Unique key used to reference this feature in your code. Cannot be changed after creation.
    pub code: String,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub entitlement: Option<Entitlement>,

    pub feature_type: FeatureType,

    pub id: FeatureId,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product: Option<EntitlementProductRef>,

    pub status: FeatureStatus,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Feature {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        code: impl Into<String>,
        created_at: chrono::DateTime<chrono::Utc>,
        feature_type: FeatureType,
        id: FeatureId,
        name: impl Into<String>,
        status: FeatureStatus,
    ) -> Self {
        Self {
            code: code.into(),
            created_at,
            description: None,
            entitlement: None,
            feature_type,
            id,
            name: name.into(),
            product: None,
            status,
            extra: serde_json::Map::new(),
        }
    }
}
