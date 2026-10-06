// this file is @generated
use serde::{Deserialize, Serialize};

use super::{coupon_discount::CouponDiscount, plan_id::PlanId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateCouponRequest {
    pub code: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub discount: CouponDiscount,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_at: Option<chrono::DateTime<chrono::Utc>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub plan_ids: Option<Vec<PlanId>>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub recurring_value: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub redemption_limit: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub reusable: Option<bool>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateCouponRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(code: impl Into<String>, discount: CouponDiscount) -> Self {
        Self {
            code: code.into(),
            description: None,
            discount,
            expires_at: None,
            plan_ids: None,
            recurring_value: None,
            redemption_limit: None,
            reusable: None,
            extra: serde_json::Map::new(),
        }
    }
}
