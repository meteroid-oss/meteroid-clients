// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    event_id::EventId, event_type::EventType, product_family_id::ProductFamilyId,
    product_fee_type_enum::ProductFeeTypeEnum, product_id::ProductId,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ProductEvent {
    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub fee_type: ProductFeeTypeEnum,

    pub name: String,

    pub product_family_id: ProductFamilyId,

    pub product_id: ProductId,

    pub id: EventId,

    pub timestamp: chrono::DateTime<chrono::Utc>,

    pub r#type: EventType,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ProductEvent {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        created_at: chrono::DateTime<chrono::Utc>,
        fee_type: ProductFeeTypeEnum,
        name: impl Into<String>,
        product_family_id: ProductFamilyId,
        product_id: ProductId,
        id: EventId,
        timestamp: chrono::DateTime<chrono::Utc>,
        r#type: EventType,
    ) -> Self {
        Self {
            created_at,
            description: None,
            fee_type,
            name: name.into(),
            product_family_id,
            product_id,
            id,
            timestamp,
            r#type,
            extra: serde_json::Map::new(),
        }
    }
}
