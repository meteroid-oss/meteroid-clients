// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    billing_cycle_reset_period::BillingCycleResetPeriod,
    calendar_reset_period::CalendarResetPeriod, fixed_window_reset_period::FixedWindowResetPeriod,
    never_reset_period::NeverResetPeriod, sliding_window_reset_period::SlidingWindowResetPeriod,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum ResetPeriod {
    BillingCycle(BillingCycleResetPeriod),
    Calendar(CalendarResetPeriod),
    FixedWindow(FixedWindowResetPeriod),
    SlidingWindow(SlidingWindowResetPeriod),
    Never(NeverResetPeriod),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl ResetPeriod {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::BillingCycle(_) => Some("BILLING_CYCLE"),
            Self::Calendar(_) => Some("CALENDAR"),
            Self::FixedWindow(_) => Some("FIXED_WINDOW"),
            Self::SlidingWindow(_) => Some("SLIDING_WINDOW"),
            Self::Never(_) => Some("NEVER"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for ResetPeriod {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::BillingCycle(value) => {
                codec::internally_tagged(serializer, "type", "BILLING_CYCLE", value)
            }
            Self::Calendar(value) => {
                codec::internally_tagged(serializer, "type", "CALENDAR", value)
            }
            Self::FixedWindow(value) => {
                codec::internally_tagged(serializer, "type", "FIXED_WINDOW", value)
            }
            Self::SlidingWindow(value) => {
                codec::internally_tagged(serializer, "type", "SLIDING_WINDOW", value)
            }
            Self::Never(value) => codec::internally_tagged(serializer, "type", "NEVER", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for ResetPeriod {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "BILLING_CYCLE" => Self::BillingCycle(codec::from_value(value)?),
            "CALENDAR" => Self::Calendar(codec::from_value(value)?),
            "FIXED_WINDOW" => Self::FixedWindow(codec::from_value(value)?),
            "SLIDING_WINDOW" => Self::SlidingWindow(codec::from_value(value)?),
            "NEVER" => Self::Never(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
