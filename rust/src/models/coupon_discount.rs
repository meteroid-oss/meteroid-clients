// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{fixed_discount::FixedDiscount, percentage_discount::PercentageDiscount};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum CouponDiscount {
    Percentage(PercentageDiscount),
    Fixed(FixedDiscount),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl CouponDiscount {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Percentage(_) => Some("PERCENTAGE"),
            Self::Fixed(_) => Some("FIXED"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for CouponDiscount {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Percentage(value) => {
                codec::internally_tagged(serializer, "type", "PERCENTAGE", value)
            }
            Self::Fixed(value) => codec::internally_tagged(serializer, "type", "FIXED", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for CouponDiscount {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "PERCENTAGE" => Self::Percentage(codec::from_value(value)?),
            "FIXED" => Self::Fixed(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
