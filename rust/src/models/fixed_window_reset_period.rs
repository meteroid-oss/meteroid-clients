// this file is @generated
use serde::{Deserialize, Serialize};

use super::calendar_unit::CalendarUnit;

/// Resets at regular intervals — anchored to your subscription's exact activation time.
#[derive(Clone, Debug, PartialEq, Deserialize, Serialize)]
#[non_exhaustive]
pub struct FixedWindowResetPeriod {
    pub interval: i32,

    pub unit: CalendarUnit,

    /// Properties this version of the SDK does not know, sent back as received.
    #[serde(flatten)]
    pub extra: serde_json::Map<String, serde_json::Value>,
}

impl FixedWindowResetPeriod {
    /// Creates a value from its required fields.
    #[must_use]
    pub fn new(interval: i32, unit: CalendarUnit) -> Self {
        Self {
            interval,
            unit,
            extra: serde_json::Map::new(),
        }
    }
}
