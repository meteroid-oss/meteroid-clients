// this file is @generated
use serde::{Deserialize, Serialize};

use super::{coupon_discount_rest::CouponDiscountRest, coupon_id::CouponId};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CouponEventData {
    pub code: String,

    pub coupon_id: CouponId,

    pub created_at: String,

    pub description: String,

    pub disabled: bool,

    pub discount: CouponDiscountRest,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub expires_at: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub recurring_value: Option<i32>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub redemption_limit: Option<i32>,

    pub reusable: bool,
}

impl CouponEventData {
    pub fn new(
        code: String,
        coupon_id: CouponId,
        created_at: String,
        description: String,
        disabled: bool,
        discount: CouponDiscountRest,
        reusable: bool,
    ) -> Self {
        Self {
            code,
            coupon_id,
            created_at,
            description,
            disabled,
            discount,
            expires_at: None,
            recurring_value: None,
            redemption_limit: None,
            reusable,
        }
    }
}
