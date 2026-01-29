// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct PackagePlanPricing {
    pub block_size: i32,

    pub rate: String,
}

impl PackagePlanPricing {
    pub fn new(block_size: i32, rate: String) -> Self {
        Self { block_size, rate }
    }
}
