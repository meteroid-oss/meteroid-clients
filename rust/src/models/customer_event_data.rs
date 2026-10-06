// this file is @generated
use serde::{Deserialize, Serialize};

use super::customer_id::CustomerId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct CustomerEventData {
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

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomerEventData {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        currency: impl Into<String>,
        custom_properties: serde_json::Value,
        customer_id: CustomerId,
        invoicing_emails: Vec<String>,
        name: impl Into<String>,
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
            extra: serde_json::Map::new(),
        }
    }
}
