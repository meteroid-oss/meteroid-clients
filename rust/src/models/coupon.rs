// this file is @generated
use serde::{Deserialize, Serialize};

use super::{coupon_discount::CouponDiscount, coupon_id::CouponId, plan_id::PlanId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct Coupon {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub archived_at: Option<chrono::DateTime<chrono::Utc>>,

    pub code: String,

    pub created_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    pub disabled: bool,

    pub discount: CouponDiscount,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_at: Option<chrono::DateTime<chrono::Utc>>,

    pub id: CouponId,

    pub plan_ids: Vec<PlanId>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub recurring_value: Option<i32>,

    pub redemption_count: i32,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub redemption_limit: Option<i32>,

    pub reusable: bool,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Coupon {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        code: impl Into<String>,
        created_at: chrono::DateTime<chrono::Utc>,
        disabled: bool,
        discount: CouponDiscount,
        id: CouponId,
        plan_ids: Vec<PlanId>,
        redemption_count: i32,
        reusable: bool,
    ) -> Self {
        Self {
            archived_at: None,
            code: code.into(),
            created_at,
            description: None,
            disabled,
            discount,
            expires_at: None,
            id,
            plan_ids,
            recurring_value: None,
            redemption_count,
            redemption_limit: None,
            reusable,
            extra: serde_json::Map::new(),
        }
    }
}
