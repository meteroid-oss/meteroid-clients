// this file is @generated
use serde::{Deserialize, Serialize};

use super::{coupon_discount::CouponDiscount, coupon_id::CouponId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CouponEventData {
    pub code: String,

    pub coupon_id: CouponId,

    pub created_at: chrono::DateTime<chrono::Utc>,

    pub description: String,

    pub disabled: bool,

    pub discount: CouponDiscount,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_at: Option<chrono::DateTime<chrono::Utc>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub recurring_value: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub redemption_limit: Option<i32>,

    pub reusable: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CouponEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        code: impl Into<String>,
        coupon_id: CouponId,
        created_at: chrono::DateTime<chrono::Utc>,
        description: impl Into<String>,
        disabled: bool,
        discount: CouponDiscount,
        reusable: bool,
    ) -> Self {
        Self {
            code: code.into(),
            coupon_id,
            created_at,
            description: description.into(),
            disabled,
            discount,
            expires_at: None,
            recurring_value: None,
            redemption_limit: None,
            reusable,
            extra: serde_json::Map::new(),
        }
    }
}
