// this file is @generated
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct LinkedSegmentationMatrix {
    pub dimension1_key: String,

    pub dimension2_key: String,

    pub values: std::collections::HashMap<String, Vec<String>>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl LinkedSegmentationMatrix {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(
        dimension1_key: impl Into<String>,
        dimension2_key: impl Into<String>,
        values: std::collections::HashMap<String, Vec<String>>,
    ) -> Self {
        Self {
            dimension1_key: dimension1_key.into(),
            dimension2_key: dimension2_key.into(),
            values,
            extra: serde_json::Map::new(),
        }
    }
}
