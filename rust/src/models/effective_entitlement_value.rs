// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    boolean_effective_entitlement_value::BooleanEffectiveEntitlementValue,
    metered_effective_entitlement_value::MeteredEffectiveEntitlementValue,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "type")]
pub enum EffectiveEntitlementValue {
    #[serde(rename = "BOOLEAN")]
    Boolean(BooleanEffectiveEntitlementValue),
    #[serde(rename = "METERED")]
    Metered(MeteredEffectiveEntitlementValue),
}

impl Default for EffectiveEntitlementValue {
    fn default() -> Self {
        Self::Boolean(BooleanEffectiveEntitlementValue::default())
    }
}
