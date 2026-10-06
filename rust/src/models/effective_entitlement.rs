// this file is @generated
use serde::{Deserialize, Serialize};

use super::{effective_entitlement_value::EffectiveEntitlementValue, feature_ref::FeatureRef};

/// Merged entitlement value for a feature for a specific customer, enriched with live usage data.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct EffectiveEntitlement {
    pub feature: FeatureRef,

    pub value: EffectiveEntitlementValue,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl EffectiveEntitlement {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(feature: FeatureRef, value: EffectiveEntitlementValue) -> Self {
        Self {
            feature,
            value,
            extra: serde_json::Map::new(),
        }
    }
}
