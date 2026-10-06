// this file is @generated
use serde::{Deserialize, Serialize};

use super::reset_period::ResetPeriod;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MeteredEntitlementValue {
    /// Per-entitlement kill switch. `false` means disabled.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub enabled: Option<bool>,

    /// Cap on usage. Null means unlimited.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub limit: Option<rust_decimal::Decimal>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub reset_period: Option<ResetPeriod>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MeteredEntitlementValue {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            enabled: None,
            limit: None,
            reset_period: None,
            extra: serde_json::Map::new(),
        }
    }
}
