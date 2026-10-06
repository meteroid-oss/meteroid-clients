// this file is @generated
use serde::{Deserialize, Serialize};

use super::{product_family_id::ProductFamilyId, product_fee_structure::ProductFeeStructure};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateProductRequest {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub catalog: Option<bool>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub fee_structure: ProductFeeStructure,

    pub name: String,

    pub product_family_id: ProductFamilyId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateProductRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        fee_structure: ProductFeeStructure,
        name: impl Into<String>,
        product_family_id: ProductFamilyId,
    ) -> Self {
        Self {
            catalog: None,
            description: None,
            fee_structure,
            name: name.into(),
            product_family_id,
            extra: serde_json::Map::new(),
        }
    }
}
