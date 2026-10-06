// this file is @generated
use serde::{Deserialize, Serialize};

use super::{connection_type::ConnectionType, customer_id::CustomerId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreateConnectedAccountRequest {
    pub connected_organization_id: uuid::Uuid,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub connection_type: Option<ConnectionType>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub metadata: Option<serde_json::Value>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub platform_customer_id: Option<CustomerId>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreateConnectedAccountRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(connected_organization_id: uuid::Uuid) -> Self {
        Self {
            connected_organization_id,
            connection_type: None,
            metadata: None,
            platform_customer_id: None,
            extra: serde_json::Map::new(),
        }
    }
}
