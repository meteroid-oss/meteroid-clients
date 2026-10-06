// this file is @generated
use serde::{Deserialize, Serialize};

use super::{billing_period_enum::BillingPeriodEnum, billing_type::BillingType};

/// Extra recurring fee
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ExtraRecurringPlanFee {
    pub billing_type: BillingType,

    pub cadence: BillingPeriodEnum,

    pub quantity: i32,

    pub unit_price: rust_decimal::Decimal,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ExtraRecurringPlanFee {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        billing_type: BillingType,
        cadence: BillingPeriodEnum,
        quantity: i32,
        unit_price: rust_decimal::Decimal,
    ) -> Self {
        Self {
            billing_type,
            cadence,
            quantity,
            unit_price,
            extra: serde_json::Map::new(),
        }
    }
}
