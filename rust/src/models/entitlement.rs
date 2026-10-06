// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    entitlement_id::EntitlementId, entitlement_value::EntitlementValue, feature_id::FeatureId,
};

/// A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription).
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Entitlement {
    pub created_at: chrono::DateTime<chrono::Utc>,

    pub feature_id: FeatureId,

    pub id: EntitlementId,

    pub updated_at: chrono::DateTime<chrono::Utc>,

    pub value: EntitlementValue,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Entitlement {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        feature_id: FeatureId,
        id: EntitlementId,
        updated_at: chrono::DateTime<chrono::Utc>,
        value: EntitlementValue,
    ) -> Self {
        Self {
            created_at,
            feature_id,
            id,
            updated_at,
            value,
            extra: serde_json::Map::new(),
        }
    }
}
