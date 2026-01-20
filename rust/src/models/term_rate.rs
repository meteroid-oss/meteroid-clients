// this file is @generated
use serde::{Deserialize, Serialize};

use super::billing_period_enum::BillingPeriodEnum;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct TermRate {
    pub price: String,

    pub term: BillingPeriodEnum,
}

impl TermRate {
    pub fn new(price: String, term: BillingPeriodEnum) -> Self {
        Self { price, term }
    }
}
