// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct PaginationResponse {
    pub page: i32,

    pub per_page: i32,

    pub total_items: i64,

    pub total_pages: i32,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl PaginationResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(page: i32, per_page: i32, total_items: i64, total_pages: i32) -> Self {
        Self {
            page,
            per_page,
            total_items,
            total_pages,
            extra: serde_json::Map::new(),
        }
    }
}
