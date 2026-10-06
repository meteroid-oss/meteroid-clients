// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    capacity_fee::CapacityFee, one_time_fee::OneTimeFee, rate_fee::RateFee,
    recurring_fee::RecurringFee, slot_fee::SlotFee, usage_fee::UsageFee,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum SubscriptionFee {
    Rate(RateFee),
    OneTime(OneTimeFee),
    Recurring(RecurringFee),
    Capacity(CapacityFee),
    Slot(SlotFee),
    Usage(UsageFee),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl SubscriptionFee {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Rate(_) => Some("RATE"),
            Self::OneTime(_) => Some("ONE_TIME"),
            Self::Recurring(_) => Some("RECURRING"),
            Self::Capacity(_) => Some("CAPACITY"),
            Self::Slot(_) => Some("SLOT"),
            Self::Usage(_) => Some("USAGE"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for SubscriptionFee {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Rate(value) => codec::internally_tagged(serializer, "type", "RATE", value),
            Self::OneTime(value) => codec::internally_tagged(serializer, "type", "ONE_TIME", value),
            Self::Recurring(value) => {
                codec::internally_tagged(serializer, "type", "RECURRING", value)
            }
            Self::Capacity(value) => {
                codec::internally_tagged(serializer, "type", "CAPACITY", value)
            }
            Self::Slot(value) => codec::internally_tagged(serializer, "type", "SLOT", value),
            Self::Usage(value) => codec::internally_tagged(serializer, "type", "USAGE", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for SubscriptionFee {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "RATE" => Self::Rate(codec::from_value(value)?),
            "ONE_TIME" => Self::OneTime(codec::from_value(value)?),
            "RECURRING" => Self::Recurring(codec::from_value(value)?),
            "CAPACITY" => Self::Capacity(codec::from_value(value)?),
            "SLOT" => Self::Slot(codec::from_value(value)?),
            "USAGE" => Self::Usage(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
