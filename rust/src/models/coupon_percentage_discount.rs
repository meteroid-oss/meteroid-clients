// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CouponPercentageDiscount {
    pub percentage: String,
}

impl CouponPercentageDiscount {
    pub fn new(percentage: String) -> Self {
        Self { percentage }
    }
}
