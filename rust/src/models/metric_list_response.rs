// this file is @generated
use serde::{Deserialize, Serialize};

use super::{metric_summary::MetricSummary, pagination_response::PaginationResponse};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct MetricListResponse {
    pub data: Vec<MetricSummary>,

    pub pagination_meta: PaginationResponse,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MetricListResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<MetricSummary>, pagination_meta: PaginationResponse) -> Self {
        Self {
            data,
            pagination_meta,
            extra: serde_json::Map::new(),
        }
    }
}
