// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{existing_price_ref::ExistingPriceRef, price_input::PriceInput};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum PriceEntry {
    Existing(ExistingPriceRef),
    New(PriceInput),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl PriceEntry {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Existing(_) => Some("EXISTING"),
            Self::New(_) => Some("NEW"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for PriceEntry {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Existing(value) => {
                codec::internally_tagged(serializer, "type", "EXISTING", value)
            }
            Self::New(value) => codec::internally_tagged(serializer, "type", "NEW", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for PriceEntry {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "EXISTING" => Self::Existing(codec::from_value(value)?),
            "NEW" => Self::New(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
