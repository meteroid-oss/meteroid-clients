// this file is @generated
use serde::{Deserialize, Serialize};

use super::unit_conversion_rounding_enum::UnitConversionRoundingEnum;

#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
pub struct UnitConversion {
    pub factor: i32,

    pub rounding: UnitConversionRoundingEnum,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl UnitConversion {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(factor: i32, rounding: UnitConversionRoundingEnum) -> Self {
        Self {
            factor,
            rounding,
            extra: serde_json::Map::new(),
        }
    }
}
