// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    product_fee_structure::ProductFeeStructure, product_fee_type_enum::ProductFeeTypeEnum,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct NewProductRef {
    pub fee_structure: ProductFeeStructure,

    pub fee_type: ProductFeeTypeEnum,

    pub name: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl NewProductRef {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        fee_structure: ProductFeeStructure,
        fee_type: ProductFeeTypeEnum,
        name: impl Into<String>,
    ) -> Self {
        Self {
            fee_structure,
            fee_type,
            name: name.into(),
            extra: serde_json::Map::new(),
        }
    }
}
