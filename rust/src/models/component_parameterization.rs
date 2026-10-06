// this file is @generated
use serde::{Deserialize, Serialize};

use super::{component_parameters::ComponentParameters, price_component_id::PriceComponentId};

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct ComponentParameterization {
    pub component_id: PriceComponentId,

    pub parameters: ComponentParameters,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl ComponentParameterization {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(component_id: PriceComponentId, parameters: ComponentParameters) -> Self {
        Self {
            component_id,
            parameters,
            extra: serde_json::Map::new(),
        }
    }
}
