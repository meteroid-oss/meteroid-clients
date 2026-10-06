// this file is @generated
use serde::{Deserialize, Serialize};

use super::{feature_ref::FeatureRef, resolved_entitlement_value::ResolvedEntitlementValue};

/// Merged entitlement value for a feature across the priority hierarchy, without usage data.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ResolvedEntitlement {
    pub feature: FeatureRef,

    pub value: ResolvedEntitlementValue,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ResolvedEntitlement {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(feature: FeatureRef, value: ResolvedEntitlementValue) -> Self {
        Self {
            feature,
            value,
            extra: serde_json::Map::new(),
        }
    }
}
