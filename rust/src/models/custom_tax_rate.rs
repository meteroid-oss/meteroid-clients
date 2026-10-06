// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct CustomTaxRate {
    pub name: String,

    pub rate: String,

    pub tax_code: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl CustomTaxRate {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        name: impl Into<String>,
        rate: impl Into<String>,
        tax_code: impl Into<String>,
    ) -> Self {
        Self {
            name: name.into(),
            rate: rate.into(),
            tax_code: tax_code.into(),
            extra: serde_json::Map::new(),
        }
    }
}
