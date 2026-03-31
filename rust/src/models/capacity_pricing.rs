// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CapacityPricing {
    pub included: i32,

    pub overage_rate: String,

    pub rate: String,
}

impl CapacityPricing {
    pub fn new(included: i32, overage_rate: String, rate: String) -> Self {
        Self {
            included,
            overage_rate,
            rate,
        }
    }
}
