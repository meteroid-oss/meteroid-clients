// this file is @generated
use std::fmt;

use serde::{Deserialize, Serialize};

#[derive(
    Clone, Copy, Debug, Default, PartialEq, Eq, PartialOrd, Ord, Hash, Serialize, Deserialize,
)]
pub enum CheckoutType {
    #[default]
    #[serde(rename = "SELF_SERVE")]
    SelfServe,

    #[serde(rename = "SUBSCRIPTION_ACTIVATION")]
    SubscriptionActivation,
}

impl fmt::Display for CheckoutType {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        let value = match self {
            Self::SelfServe => "SELF_SERVE",
            Self::SubscriptionActivation => "SUBSCRIPTION_ACTIVATION",
        };
        f.write_str(value)
    }
}
