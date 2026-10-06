// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    slot_downgrade_policy_enum::SlotDowngradePolicyEnum,
    slot_upgrade_policy_enum::SlotUpgradePolicyEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct SlotFeeStructure {
    pub downgrade_policy: SlotDowngradePolicyEnum,

    pub slot_unit_name: String,

    pub upgrade_policy: SlotUpgradePolicyEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl SlotFeeStructure {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        downgrade_policy: SlotDowngradePolicyEnum,
        slot_unit_name: impl Into<String>,
        upgrade_policy: SlotUpgradePolicyEnum,
    ) -> Self {
        Self {
            downgrade_policy,
            slot_unit_name: slot_unit_name.into(),
            upgrade_policy,
            extra: serde_json::Map::new(),
        }
    }
}
