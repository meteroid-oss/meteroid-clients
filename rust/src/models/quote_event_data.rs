// this file is @generated
use serde::{Deserialize, Serialize};

use super::{customer_id::CustomerId, quote_id::QuoteId, subscription_id::SubscriptionId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct QuoteEventData {
    pub customer_id: CustomerId,

    pub quote_id: QuoteId,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub subscription_id: Option<SubscriptionId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl QuoteEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(customer_id: CustomerId, quote_id: QuoteId) -> Self {
        Self {
            customer_id,
            quote_id,
            subscription_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
