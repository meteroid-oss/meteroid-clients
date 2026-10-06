// this file is @generated
use serde::{Deserialize, Serialize};

use super::{applied_coupon::AppliedCoupon, subscription_coupon::SubscriptionCoupon};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct AppliedCouponDetailed {
    pub applied_coupon: AppliedCoupon,

    pub coupon: SubscriptionCoupon,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl AppliedCouponDetailed {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(applied_coupon: AppliedCoupon, coupon: SubscriptionCoupon) -> Self {
        Self {
            applied_coupon,
            coupon,
            extra: serde_json::Map::new(),
        }
    }
}
