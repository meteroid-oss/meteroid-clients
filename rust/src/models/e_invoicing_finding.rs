// this file is @generated
use serde::{Deserialize, Serialize};

/// One rule the document did not satisfy, in the standard's own vocabulary.
#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct EInvoicingFinding {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub hint: Option<String>,

    pub message: String,

    /// The rule identifier — "BR-11", "PEPPOL-EN16931-R003".
    pub rule: String,

    /// The business term path it is about — "BG-8/BT-55".
    pub term: String,
}

impl EInvoicingFinding {
    pub fn new(message: String, rule: String, term: String) -> Self {
        Self {
            hint: None,
            message,
            rule,
            term,
        }
    }
}
