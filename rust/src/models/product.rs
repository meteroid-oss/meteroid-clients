// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    product_family_id::ProductFamilyId, product_fee_structure::ProductFeeStructure,
    product_fee_type_enum::ProductFeeTypeEnum, product_id::ProductId,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Product {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub archived_at: Option<chrono::DateTime<chrono::Utc>>,

    pub catalog: bool,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub fee_structure: ProductFeeStructure,

    pub fee_type: ProductFeeTypeEnum,

    pub id: ProductId,

    pub name: String,

    pub product_family_id: ProductFamilyId,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Product {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        catalog: bool,
        created_at: chrono::DateTime<chrono::Utc>,
        fee_structure: ProductFeeStructure,
        fee_type: ProductFeeTypeEnum,
        id: ProductId,
        name: impl Into<String>,
        product_family_id: ProductFamilyId,
    ) -> Self {
        Self {
            archived_at: None,
            catalog,
            created_at,
            description: None,
            fee_structure,
            fee_type,
            id,
            name: name.into(),
            product_family_id,
            extra: serde_json::Map::new(),
        }
    }
}
