// this file is @generated
use serde::{Deserialize, Serialize};

/// One rule the document did not satisfy, in the standard's own vocabulary.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct EInvoicingFinding {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub hint: Option<String>,

    pub message: String,

    /// The rule identifier — "BR-11", "PEPPOL-EN16931-R003".
    pub rule: String,

    /// The business term path it is about — "BG-8/BT-55".
    pub term: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl EInvoicingFinding {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        message: impl Into<String>,
        rule: impl Into<String>,
        term: impl Into<String>,
    ) -> Self {
        Self {
            hint: None,
            message: message.into(),
            rule: rule.into(),
            term: term.into(),
            extra: serde_json::Map::new(),
        }
    }
}
