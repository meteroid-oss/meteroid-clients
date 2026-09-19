// this file is @generated
use serde::{Deserialize, Serialize};

use super::error_code::ErrorCode;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct RestErrorResponse {
    pub code: ErrorCode,

    pub message: String,
}

impl RestErrorResponse {
    pub fn new(code: ErrorCode, message: String) -> Self {
        Self { code, message }
    }
}
