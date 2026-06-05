// this file is @generated
use serde::{Deserialize, Serialize};

use super::{
    entitlement::Entitlement, feature_id::FeatureId, feature_status::FeatureStatus,
    feature_type::FeatureType, product_ref::ProductRef,
};

#[derive(Clone, Debug, Default, PartialEq, Deserialize, Serialize)]
pub struct Feature {
    pub created_at: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub entitlement: Option<Entitlement>,

    pub feature_type: FeatureType,

    pub id: FeatureId,

    pub name: String,

    #[serde(skip_serializing_if = "Option::is_none")]
    pub product: Option<ProductRef>,

    pub status: FeatureStatus,
}

impl Feature {
    pub fn new(
        created_at: String,
        feature_type: FeatureType,
        id: FeatureId,
        name: String,
        status: FeatureStatus,
    ) -> Self {
        Self {
            created_at,
            description: None,
            entitlement: None,
            feature_type,
            id,
            name,
            product: None,
            status,
        }
    }
}
