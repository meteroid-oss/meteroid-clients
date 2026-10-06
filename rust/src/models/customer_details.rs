// this file is @generated
use serde::{Deserialize, Serialize};

use super::{address::Address, customer_id::CustomerId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CustomerDetails {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_address: Option<Address>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub email: Option<String>,

    pub id: CustomerId,

    pub name: String,

    pub snapshot_at: chrono::DateTime<chrono::Utc>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub vat_number: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomerDetails {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        id: CustomerId,
        name: impl Into<String>,
        snapshot_at: chrono::DateTime<chrono::Utc>,
    ) -> Self {
        Self {
            alias: None,
            billing_address: None,
            email: None,
            id,
            name: name.into(),
            snapshot_at,
            vat_number: None,
            extra: serde_json::Map::new(),
        }
    }
}
