// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct CapacityThreshold {
    pub included_amount: i32,

    pub per_unit_overage: String,

    pub price: String,
}

impl CapacityThreshold {
    pub fn new(included_amount: i32, per_unit_overage: String, price: String) -> Self {
        Self {
            included_amount,
            per_unit_overage,
            price,
        }
    }
}
