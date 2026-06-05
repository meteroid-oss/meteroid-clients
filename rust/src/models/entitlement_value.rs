// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    boolean_entitlement_value::BooleanEntitlementValue,
    metered_entitlement_value::MeteredEntitlementValue,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "type")]
pub enum EntitlementValue {
    #[serde(rename = "BOOLEAN")]
    Boolean(BooleanEntitlementValue),
    #[serde(rename = "METERED")]
    Metered(MeteredEntitlementValue),
}

impl Default for EntitlementValue {
    fn default() -> Self {
        Self::Boolean(BooleanEntitlementValue::default())
    }
}
