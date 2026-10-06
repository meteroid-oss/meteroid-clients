// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CouponLineItem {
    pub coupon_id: String,

    pub name: String,

    pub total: i64,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CouponLineItem {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(coupon_id: impl Into<String>, name: impl Into<String>, total: i64) -> Self {
        Self {
            coupon_id: coupon_id.into(),
            name: name.into(),
            total,
            extra: serde_json::Map::new(),
        }
    }
}
