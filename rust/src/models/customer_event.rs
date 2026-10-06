// this file is @generated
use serde::{Deserialize, Serialize};

use super::{customer_id::CustomerId, event_id::EventId, event_type::EventType};

/// Event-specific webhook schemas for type-safe webhook payloads
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CustomerEvent {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub alias: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub billing_email: Option<String>,

    pub currency: String,

    /// User-defined custom property values, keyed by definition key.
    pub custom_properties: serde_json::Value,

    pub customer_id: CustomerId,

    pub invoicing_emails: Vec<String>,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone: Option<String>,

    pub id: EventId,

    pub timestamp: chrono::DateTime<chrono::Utc>,

    pub r#type: EventType,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomerEvent {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        currency: impl Into<String>,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        invoicing_emails: Vec<String>,
        name: impl Into<String>,
        id: EventId,
        timestamp: chrono::DateTime<chrono::Utc>,
        r#type: EventType,
    ) -> Self {
        Self {
            alias: None,
            billing_email: None,
            currency: currency.into(),
            custom_properties,
            customer_id,
            invoicing_emails,
            name: name.into(),
            phone: None,
            id,
            timestamp,
            r#type,
            extra: serde_json::Map::new(),
        }
    }
}
