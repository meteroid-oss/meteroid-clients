// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct TierRow {
    pub first_unit: i32,

    pub flat_cap: rust_decimal::Decimal,

    pub flat_fee: rust_decimal::Decimal,

    pub rate: rust_decimal::Decimal,
}

impl TierRow {
    pub fn new(
        first_unit: i32,
        flat_cap: rust_decimal::Decimal,
        flat_fee: rust_decimal::Decimal,
        rate: rust_decimal::Decimal,
    ) -> Self {
        Self {
            first_unit,
            flat_cap,
            flat_fee,
            rate,
        }
    }
}
