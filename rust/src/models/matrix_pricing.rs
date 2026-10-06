// this file is @generated
use serde::{Deserialize, Serialize};

use super::matrix_row::MatrixRow;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct MatrixPricing {
    pub rates: Vec<MatrixRow>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MatrixPricing {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(rates: Vec<MatrixRow>) -> Self {
        Self {
            rates,
            extra: serde_json::Map::new(),
        }
    }
}
