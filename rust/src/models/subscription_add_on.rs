// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    add_on_id::AddOnId, subscription_fee::SubscriptionFee,
    subscription_fee_billing_period_enum::SubscriptionFeeBillingPeriodEnum,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct SubscriptionAddOn {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub add_on_id: Option<AddOnId>,

    pub fee: SubscriptionFee,

    pub name: String,

    pub period: SubscriptionFeeBillingPeriodEnum,
}

impl SubscriptionAddOn {
    pub fn new(
        fee: SubscriptionFee,
        name: String,
        period: SubscriptionFeeBillingPeriodEnum,
    ) -> Self {
        Self {
            add_on_id: None,
            fee,
            name,
            period,
        }
    }
}
