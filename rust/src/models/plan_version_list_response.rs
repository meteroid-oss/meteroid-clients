// this file is @generated
use serde::{Deserialize, Serialize};

use super::{pagination_response::PaginationResponse, plan_version_summary::PlanVersionSummary};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PlanVersionListResponse {
    pub data: Vec<PlanVersionSummary>,

    pub pagination_meta: PaginationResponse,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PlanVersionListResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<PlanVersionSummary>, pagination_meta: PaginationResponse) -> Self {
        Self {
            data,
            pagination_meta,
            extra: serde_json::Map::new(),
        }
    }
}
