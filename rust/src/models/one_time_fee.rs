// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct OneTimeFee {
    pub quantity: i32,

    pub rate: String,
}

impl OneTimeFee {
    pub fn new(quantity: i32, rate: String) -> Self {
        Self { quantity, rate }
    }
}
