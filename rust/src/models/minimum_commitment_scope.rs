// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{all_components_scope::AllComponentsScope, products_scope::ProductsScope};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum MinimumCommitmentScope {
    AllComponents(AllComponentsScope),
    Products(ProductsScope),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl MinimumCommitmentScope {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::AllComponents(_) => Some("all_components"),
            Self::Products(_) => Some("products"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for MinimumCommitmentScope {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::AllComponents(value) => {
                codec::internally_tagged(serializer, "type", "all_components", value)
            }
            Self::Products(value) => {
                codec::internally_tagged(serializer, "type", "products", value)
            }
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for MinimumCommitmentScope {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "all_components" => Self::AllComponents(codec::from_value(value)?),
            "products" => Self::Products(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
