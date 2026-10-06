// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    add_on_id::AddOnId, price_id::PriceId, product_fee_type_enum::ProductFeeTypeEnum,
    product_id::ProductId,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct AddOnEventData {
    pub add_on_id: AddOnId,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub fee_type: Option<ProductFeeTypeEnum>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_instances_per_subscription: Option<i32>,

    pub name: String,

    pub price_id: PriceId,

    pub product_id: ProductId,

    pub self_serviceable: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl AddOnEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        add_on_id: AddOnId,
        created_at: chrono::DateTime<chrono::Utc>,
        name: impl Into<String>,
        price_id: PriceId,
        product_id: ProductId,
        self_serviceable: bool,
    ) -> Self {
        Self {
            add_on_id,
            created_at,
            description: None,
            fee_type: None,
            max_instances_per_subscription: None,
            name: name.into(),
            price_id,
            product_id,
            self_serviceable,
            extra: serde_json::Map::new(),
        }
    }
}
