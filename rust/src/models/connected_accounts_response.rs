// this file is @generated
use serde::{Deserialize, Serialize};

use super::connected_account::ConnectedAccount;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ConnectedAccountsResponse {
    pub data: Vec<ConnectedAccount>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ConnectedAccountsResponse {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(data: Vec<ConnectedAccount>) -> Self {
        Self {
            data,
            extra: serde_json::Map::new(),
        }
    }
}
