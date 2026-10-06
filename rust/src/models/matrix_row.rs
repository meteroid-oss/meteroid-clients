// this file is @generated
use serde::{Deserialize, Serialize};

use super::matrix_dimension::MatrixDimension;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct MatrixRow {
    pub dimension1: MatrixDimension,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub dimension2: Option<MatrixDimension>,

    pub per_unit_price: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl MatrixRow {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(dimension1: MatrixDimension, per_unit_price: rust_decimal::Decimal) -> Self {
        Self {
            dimension1,
            dimension2: None,
            per_unit_price,
            extra: serde_json::Map::new(),
        }
    }
}
