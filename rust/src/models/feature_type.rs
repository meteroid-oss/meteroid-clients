// this file is @generated
use serde::{Deserialize, Serialize};

use super::{boolean_feature_type::BooleanFeatureType, metered_feature_type::MeteredFeatureType};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[serde(tag = "type")]
pub enum FeatureType {
    #[serde(rename = "BOOLEAN")]
    Boolean(BooleanFeatureType),
    #[serde(rename = "METERED")]
    Metered(MeteredFeatureType),
}

impl Default for FeatureType {
    fn default() -> Self {
        Self::Boolean(BooleanFeatureType::default())
    }
}
