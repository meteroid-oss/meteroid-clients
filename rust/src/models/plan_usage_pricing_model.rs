// this file is @generated
use serde::{Deserialize, Deserializer, Serialize, Serializer};

use super::{
    matrix_plan_pricing::MatrixPlanPricing, package_plan_pricing::PackagePlanPricing,
    per_unit_plan_pricing::PerUnitPlanPricing, tiered_plan_pricing::TieredPlanPricing,
    volume_plan_pricing::VolumePlanPricing,
};
use crate::models::codec;

/// Variants are told apart by `type`.
#[derive(Clone, Debug, PartialEq)]
#[non_exhaustive]
pub enum PlanUsagePricingModel {
    PerUnit(PerUnitPlanPricing),
    Tiered(TieredPlanPricing),
    Volume(VolumePlanPricing),
    Package(PackagePlanPricing),
    Matrix(MatrixPlanPricing),
    /// A variant this version of the SDK does not know yet, as received.
    Unknown(serde_json::Value),
}

impl PlanUsagePricingModel {
    /// The `type` value of this variant.
    #[must_use]
    pub fn tag(&self) -> Option<&str> {
        match self {
            Self::PerUnit(_) => Some("PER_UNIT"),
            Self::Tiered(_) => Some("TIERED"),
            Self::Volume(_) => Some("VOLUME"),
            Self::Package(_) => Some("PACKAGE"),
            Self::Matrix(_) => Some("MATRIX"),
            Self::Unknown(value) => value.get("type")?.as_str(),
        }
    }
}

impl Serialize for PlanUsagePricingModel {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        match self {
            Self::PerUnit(value) => codec::internally_tagged(serializer, "type", "PER_UNIT", value),
            Self::Tiered(value) => codec::internally_tagged(serializer, "type", "TIERED", value),
            Self::Volume(value) => codec::internally_tagged(serializer, "type", "VOLUME", value),
            Self::Package(value) => codec::internally_tagged(serializer, "type", "PACKAGE", value),
            Self::Matrix(value) => codec::internally_tagged(serializer, "type", "MATRIX", value),
            Self::Unknown(value) => value.serialize(serializer),
        }
    }
}

impl<'de> Deserialize<'de> for PlanUsagePricingModel {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        let (tag, value) = codec::split_tag(deserializer, "type")?;
        Ok(match tag.as_str() {
            "PER_UNIT" => Self::PerUnit(codec::from_value(value)?),
            "TIERED" => Self::Tiered(codec::from_value(value)?),
            "VOLUME" => Self::Volume(codec::from_value(value)?),
            "PACKAGE" => Self::Package(codec::from_value(value)?),
            "MATRIX" => Self::Matrix(codec::from_value(value)?),
            _ => Self::Unknown(value),
        })
    }
}
