// this file is @generated
use serde::{Deserialize, Serialize};

use super::subscription::Subscription;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CancelSubscriptionResponse {
    pub subscription: Subscription,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CancelSubscriptionResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(subscription: Subscription) -> Self {
        Self {
            subscription,
            extra: serde_json::Map::new(),
        }
    }
}
