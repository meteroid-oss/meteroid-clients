// this file is @generated
use serde::{Deserialize, Serialize};

use super::{feature_id::FeatureId, product_ref::ProductRef};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct FeatureRef {
    pub id: FeatureId,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product: Option<ProductRef>,
}

impl FeatureRef {
    pub fn new(id: FeatureId, name: String) -> Self {
        Self {
            id,
            name,
            product: None,
        }
    }
}
