// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct RateFee {
    pub rate: String,
}

impl RateFee {
    pub fn new(rate: String) -> Self {
        Self { rate }
    }
}
