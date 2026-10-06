// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    capacity_plan_fee::CapacityPlanFee, extra_recurring_plan_fee::ExtraRecurringPlanFee,
    one_time_plan_fee::OneTimePlanFee, rate_plan_fee::RatePlanFee, slot_plan_fee::SlotPlanFee,
    usage_plan_fee::UsagePlanFee,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum Fee {
    Rate(RatePlanFee),
    Slot(SlotPlanFee),
    Capacity(CapacityPlanFee),
    Usage(UsagePlanFee),
    ExtraRecurring(ExtraRecurringPlanFee),
    OneTime(OneTimePlanFee),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl Fee {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Rate(_) => Some("RATE"),
            Self::Slot(_) => Some("SLOT"),
            Self::Capacity(_) => Some("CAPACITY"),
            Self::Usage(_) => Some("USAGE"),
            Self::ExtraRecurring(_) => Some("EXTRA_RECURRING"),
            Self::OneTime(_) => Some("ONE_TIME"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for Fee {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Rate(value) => codec::internally_tagged(serializer, "type", "RATE", value),
            Self::Slot(value) => codec::internally_tagged(serializer, "type", "SLOT", value),
            Self::Capacity(value) => {
                codec::internally_tagged(serializer, "type", "CAPACITY", value)
            }
            Self::Usage(value) => codec::internally_tagged(serializer, "type", "USAGE", value),
            Self::ExtraRecurring(value) => {
                codec::internally_tagged(serializer, "type", "EXTRA_RECURRING", value)
            }
            Self::OneTime(value) => codec::internally_tagged(serializer, "type", "ONE_TIME", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for Fee {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "RATE" => Self::Rate(codec::from_value(value)?),
            "SLOT" => Self::Slot(codec::from_value(value)?),
            "CAPACITY" => Self::Capacity(codec::from_value(value)?),
            "USAGE" => Self::Usage(codec::from_value(value)?),
            "EXTRA_RECURRING" => Self::ExtraRecurring(codec::from_value(value)?),
            "ONE_TIME" => Self::OneTime(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
