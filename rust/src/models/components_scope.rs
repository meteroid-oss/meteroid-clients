// this file is @generated
use serde::{Deserialize, Serialize};

/// Component names — matched against `ReplacePlanRequest::components[].name`.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ComponentsScope {
    pub component_names: Vec<String>,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ComponentsScope {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(component_names: Vec<String>) -> Self {
        Self {
            component_names,
            extra: serde_json::Map::new(),
        }
    }
}
