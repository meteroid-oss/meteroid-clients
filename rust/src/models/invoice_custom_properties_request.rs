// this file is @generated
use serde::{Deserialize, Serialize};

/// Merge update of an invoice's custom property values (send a key with `null` to remove it).
/// Allowed at any status — custom properties stay editable after the invoice is finalized.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct InvoiceCustomPropertiesRequest {
    pub custom_properties: serde_json::Value,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl InvoiceCustomPropertiesRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(custom_properties: serde_json::Value) -> Self {
        Self {
            custom_properties,
            extra: serde_json::Map::new(),
        }
    }
}
