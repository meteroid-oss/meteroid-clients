// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    metered_entitlement_spec::MeteredEntitlementSpec,
    metered_entitlement_usage::MeteredEntitlementUsage,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MeteredEffectiveEntitlementValue {
    pub spec: MeteredEntitlementSpec,

    pub usage: MeteredEntitlementUsage,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MeteredEffectiveEntitlementValue {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(spec: MeteredEntitlementSpec, usage: MeteredEntitlementUsage) -> Self {
        Self {
            spec,
            usage,
            extra: serde_json::Map::new(),
        }
    }
}
