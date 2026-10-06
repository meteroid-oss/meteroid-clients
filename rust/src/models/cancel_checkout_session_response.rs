// this file is @generated
use serde::{Deserialize, Serialize};

use super::checkout_session::CheckoutSession;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CancelCheckoutSessionResponse {
    pub session: CheckoutSession,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CancelCheckoutSessionResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(session: CheckoutSession) -> Self {
        Self {
            session,
            extra: serde_json::Map::new(),
        }
    }
}
