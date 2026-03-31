// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    coupon_fixed_discount::CouponFixedDiscount,
    coupon_percentage_discount::CouponPercentageDiscount,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "discount_type")]
pub enum CouponDiscountRest {
    #[serde(rename = "PERCENTAGE")]
    Percentage(CouponPercentageDiscount),
    #[serde(rename = "FIXED")]
    Fixed(CouponFixedDiscount),
}

impl Default for CouponDiscountRest {
    fn default() -> Self {
        Self::Percentage(CouponPercentageDiscount::default())
    }
}
