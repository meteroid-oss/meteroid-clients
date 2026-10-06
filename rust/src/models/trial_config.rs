// this file is @generated
use serde::{Deserialize, Serialize};

use super::plan_id::PlanId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct TrialConfig {
    pub duration_days: i32,

    pub is_free: bool,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub trialing_plan_id: Option<PlanId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl TrialConfig {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(duration_days: i32, is_free: bool) -> Self {
        Self {
            duration_days,
            is_free,
            trialing_plan_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
