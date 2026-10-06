// this file is @generated
use serde::{Deserialize, Serialize};

use super::error_code::ErrorCode;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct RestErrorResponse {
    pub code: ErrorCode,

    pub message: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl RestErrorResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(code: ErrorCode, message: impl Into<String>) -> Self {
        Self {
            code,
            message: message.into(),
            extra: serde_json::Map::new(),
        }
    }
}
