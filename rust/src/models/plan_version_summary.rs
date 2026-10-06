// this file is @generated
use serde::{Deserialize, Serialize};

use super::plan_version_id::PlanVersionId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PlanVersionSummary {
    pub created_at: chrono::DateTime<chrono::Utc>,

    pub currency: String,

    pub id: PlanVersionId,

    pub is_draft: bool,

    pub version: i32,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PlanVersionSummary {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        currency: impl Into<String>,
        id: PlanVersionId,
        is_draft: bool,
        version: i32,
    ) -> Self {
        Self {
            created_at,
            currency: currency.into(),
            id,
            is_draft,
            version,
            extra: serde_json::Map::new(),
        }
    }
}
