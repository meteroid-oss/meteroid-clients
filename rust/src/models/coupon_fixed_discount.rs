// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CouponFixedDiscount {
    pub amount: String,

    pub currency: String,
}

impl CouponFixedDiscount {
    pub fn new(amount: String, currency: String) -> Self {
        Self { amount, currency }
    }
}
