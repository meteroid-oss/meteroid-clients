// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct PerUnitPlanPricing {
    pub rate: String,
}

impl PerUnitPlanPricing {
    pub fn new(rate: String) -> Self {
        Self { rate }
    }
}
