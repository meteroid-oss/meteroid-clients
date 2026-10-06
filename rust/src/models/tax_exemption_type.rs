// this file is @generated
use std::fmt;

use serde::{Deserialize, Deserializer, Serialize, Serializer};

#[derive(Clone, Debug, PartialEq, Eq, PartialOrd, Ord, Hash)]
#[non_exhaustive]
pub enum TaxExemptionType {
    ReverseCharge,
    TaxExempt,
    NotRegistered,
    Export,
    NoVatTerritory,
    /// A value this version of the SDK does not know yet.
    Unknown(String),
}

impl TaxExemptionType {
    /// The value as sent on the wire.
    #[must_use]
    pub fn as_str(&self) -> &str {
        match self {
            Self::ReverseCharge => "REVERSE_CHARGE",
            Self::TaxExempt => "TAX_EXEMPT",
            Self::NotRegistered => "NOT_REGISTERED",
            Self::Export => "EXPORT",
            Self::NoVatTerritory => "NO_VAT_TERRITORY",
            Self::Unknown(value) => value,
        }
    }
}

impl From<&str> for TaxExemptionType {
    fn from(value: &str) -> Self {
        match value {
            "REVERSE_CHARGE" => Self::ReverseCharge,
            "TAX_EXEMPT" => Self::TaxExempt,
            "NOT_REGISTERED" => Self::NotRegistered,
            "EXPORT" => Self::Export,
            "NO_VAT_TERRITORY" => Self::NoVatTerritory,
            other => Self::Unknown(other.to_owned()),
        }
    }
}

impl fmt::Display for TaxExemptionType {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        f.write_str(self.as_str())
    }
}

impl Serialize for TaxExemptionType {
    fn serialize<S: Serializer>(&self, serializer: S) -> Result<S::Ok, S::Error> {
        serializer.serialize_str(self.as_str())
    }
}

impl<'de> Deserialize<'de> for TaxExemptionType {
    fn deserialize<D: Deserializer<'de>>(deserializer: D) -> Result<Self, D::Error> {
        String::deserialize(deserializer).map(|value| Self::from(value.as_str()))
    }
}

impl crate::request::QueryParamValue for TaxExemptionType {
    fn encode(&self) -> String {
        self.to_string()
    }
}
