// this file is @generated
use serde::{Deserialize, Serialize};

use super::country_code::CountryCode;

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct Address {
    #[serde(skip_serializing_if = "Option::is_none")]
    pub city: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub country: Option<CountryCode>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub line1: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub line2: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub state: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub zip_code: Option<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl Address {
    /// Creates a value with every field unset.
    #[must_use]
    pub fn new() -> Self {
        Self {
            city: None,
            country: None,
            line1: None,
            line2: None,
            state: None,
            zip_code: None,
            extra: serde_json::Map::new(),
        }
    }
}
