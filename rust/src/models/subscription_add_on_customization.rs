// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    subscription_add_on_parameterization::SubscriptionAddOnParameterization,
    subscription_add_on_price_override::SubscriptionAddOnPriceOverride,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum SubscriptionAddOnCustomization {
    PriceOverride(SubscriptionAddOnPriceOverride),
    Parameterization(SubscriptionAddOnParameterization),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl SubscriptionAddOnCustomization {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::PriceOverride(_) => Some("PRICE_OVERRIDE"),
            Self::Parameterization(_) => Some("PARAMETERIZATION"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for SubscriptionAddOnCustomization {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::PriceOverride(value) => {
                codec::internally_tagged(serializer, "type", "PRICE_OVERRIDE", value)
            }
            Self::Parameterization(value) => {
                codec::internally_tagged(serializer, "type", "PARAMETERIZATION", value)
            }
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for SubscriptionAddOnCustomization {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "PRICE_OVERRIDE" => Self::PriceOverride(codec::from_value(value)?),
            "PARAMETERIZATION" => Self::Parameterization(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
