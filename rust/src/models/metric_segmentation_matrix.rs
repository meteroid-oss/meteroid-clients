// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    double_segmentation_matrix::DoubleSegmentationMatrix,
    linked_segmentation_matrix::LinkedSegmentationMatrix, metric_dimension::MetricDimension,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum MetricSegmentationMatrix {
    Single(MetricDimension),
    Double(DoubleSegmentationMatrix),
    Linked(LinkedSegmentationMatrix),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl MetricSegmentationMatrix {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::Single(_) => Some("SINGLE"),
            Self::Double(_) => Some("DOUBLE"),
            Self::Linked(_) => Some("LINKED"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for MetricSegmentationMatrix {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::Single(value) => codec::internally_tagged(serializer, "type", "SINGLE", value),
            Self::Double(value) => codec::internally_tagged(serializer, "type", "DOUBLE", value),
            Self::Linked(value) => codec::internally_tagged(serializer, "type", "LINKED", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for MetricSegmentationMatrix {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "SINGLE" => Self::Single(codec::from_value(value)?),
            "DOUBLE" => Self::Double(codec::from_value(value)?),
            "LINKED" => Self::Linked(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
