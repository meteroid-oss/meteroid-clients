// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct RatePricing {
    pub rate: String,
}

impl RatePricing {
    pub fn new(rate: String) -> Self {
        Self { rate }
    }
}
