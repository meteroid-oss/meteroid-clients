// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CouponLineItem {
    pub coupon_id: String,

    pub name: String,

    pub total: i64,
}

impl CouponLineItem {
    pub fn new(coupon_id: String, name: String, total: i64) -> Self {
        Self {
            coupon_id,
            name,
            total,
        }
    }
}
