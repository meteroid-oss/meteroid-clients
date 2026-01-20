// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    subscription_add_on_override::SubscriptionAddOnOverride,
    subscription_add_on_parameterization::SubscriptionAddOnParameterization,
};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "discriminator")]
pub enum SubscriptionAddOnCustomization {
    #[serde(rename = "OVERRIDE")]
    Override(SubscriptionAddOnOverride),
    #[serde(rename = "PARAMETERIZATION")]
    Parameterization(SubscriptionAddOnParameterization),
}

impl Default for SubscriptionAddOnCustomization {
    fn default() -> Self {
        Self::Override(SubscriptionAddOnOverride::default())
    }
}
