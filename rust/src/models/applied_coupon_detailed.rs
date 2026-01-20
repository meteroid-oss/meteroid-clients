// this file is @generated
use serde::{Deserialize, Serialize};

use super::{applied_coupon::AppliedCoupon, coupon::Coupon};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct AppliedCouponDetailed {
    pub applied_coupon: AppliedCoupon,

    pub coupon: Coupon,
}

impl AppliedCouponDetailed {
    pub fn new(applied_coupon: AppliedCoupon, coupon: Coupon) -> Self {
        Self {
            applied_coupon,
            coupon,
        }
    }
}
