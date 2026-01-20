// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    subscription_fee::SubscriptionFee,
    subscription_fee_billing_period_enum::SubscriptionFeeBillingPeriodEnum,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionAddOnOverride {
    pub fee: SubscriptionFee,

    pub name: String,

    pub period: SubscriptionFeeBillingPeriodEnum,
}

impl SubscriptionAddOnOverride {
    pub fn new(
        fee: SubscriptionFee,
        name: String,
        period: SubscriptionFeeBillingPeriodEnum,
    ) -> Self {
        Self { fee, name, period }
    }
}
