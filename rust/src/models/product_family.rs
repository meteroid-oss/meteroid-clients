// this file is @generated
use serde::{Deserialize, Serialize};

use super::product_family_id::ProductFamilyId;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct ProductFamily {
    pub id: ProductFamilyId,

    pub name: String,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ProductFamily {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(id: ProductFamilyId, name: impl Into<String>) -> Self {
        Self {
            id,
            name: name.into(),
            extra: serde_json::Map::new(),
        }
    }
}
