// this file is @generated
use serde::{Deserialize, Serialize};

/// Merge update of a credit note's custom property values (send a key with `null` to remove it).
/// Allowed at any status — custom properties stay editable after the credit note is finalized.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CreditNoteCustomPropertiesRequest {
    pub custom_properties: serde_json::Value,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CreditNoteCustomPropertiesRequest {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(custom_properties: serde_json::Value) -> Self {
        Self {
            custom_properties,
            extra: serde_json::Map::new(),
        }
    }
}
