// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct TierRow {
    pub first_unit: i32,

    pub flat_cap: String,

    pub flat_fee: String,

    pub rate: String,
}

impl TierRow {
    pub fn new(first_unit: i32, flat_cap: String, flat_fee: String, rate: String) -> Self {
        Self {
            first_unit,
            flat_cap,
            flat_fee,
            rate,
        }
    }
}
