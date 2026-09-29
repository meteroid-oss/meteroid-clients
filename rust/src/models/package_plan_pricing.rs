// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct PackagePlanPricing {
    pub block_size: i64,

    pub rate: rust_decimal::Decimal,
}

impl PackagePlanPricing {
    pub fn new(block_size: i64, rate: rust_decimal::Decimal) -> Self {
        Self { block_size, rate }
    }
}
