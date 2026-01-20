// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct PerUnitPricing {
    pub rate: String,
}

impl PerUnitPricing {
    pub fn new(rate: String) -> Self {
        Self { rate }
    }
}
