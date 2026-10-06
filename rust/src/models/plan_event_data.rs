// this file is @generated
use serde::{Deserialize, Serialize};

use super::{plan_id::PlanId, plan_status_enum::PlanStatusEnum, plan_type_enum::PlanTypeEnum};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PlanEventData {
    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub name: String,

    pub plan_id: PlanId,

    pub plan_type: PlanTypeEnum,

    pub status: PlanStatusEnum,

    pub version: i32,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PlanEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        currency: impl Into<String>,
        name: impl Into<String>,
        plan_id: PlanId,
        plan_type: PlanTypeEnum,
        status: PlanStatusEnum,
        version: i32,
    ) -> Self {
        Self {
            created_at,
            currency: currency.into(),
            description: None,
            name: name.into(),
            plan_id,
            plan_type,
            status,
            version,
            extra: serde_json::Map::new(),
        }
    }
}
