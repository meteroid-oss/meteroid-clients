// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct OneTimePricing {
    pub quantity: i32,

    pub unit_price: String,
}

impl OneTimePricing {
    pub fn new(quantity: i32, unit_price: String) -> Self {
        Self {
            quantity,
            unit_price,
        }
    }
}
