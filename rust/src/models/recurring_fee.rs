// this file is @generated
use serde::{Deserialize, Serialize};

use super::billing_type_enum::BillingTypeEnum;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct RecurringFee {
    pub billing_type: BillingTypeEnum,

    pub quantity: i32,

    pub rate: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl RecurringFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(billing_type: BillingTypeEnum, quantity: i32, rate: rust_decimal::Decimal) -> Self {
        Self {
            billing_type,
            quantity,
            rate,
            extra: serde_json::Map::new(),
        }
    }
}
